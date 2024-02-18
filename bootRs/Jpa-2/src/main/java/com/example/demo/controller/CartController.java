package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.vo.CartInfo;
import com.example.demo.service.OrderDAO;
import com.example.demo.service.ProductDAO;
import com.example.demo.vo.ProductInfo;
import com.example.demo.util.Utils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CartController {
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	ProductDAO productDAO;

	@GetMapping(value = { "/buyProduct" })
	public RedirectView listProductBuy(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") String code) {

		Product product = null;
		if (code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if (product != null) {

			CartInfo cartInfo = Utils.getCartInSession(request);
			ProductInfo productInfo = new ProductInfo(product);

			cartInfo.addProduct(productInfo, 1);
		}

		return new RedirectView("/shoppingCart");
	}

	@GetMapping(value = { "/shoppingCart" })
	public ModelAndView shoppingCartView(HttpServletRequest request, Model model) {
		CartInfo myCart = Utils.getCartInSession(request);
		model.addAttribute("cartForm", myCart);
		return new ModelAndView("shoppingCart");
	}

	// POST: Update quantity for product in cart
	@PostMapping(value = { "/shoppingCart" })
	public RedirectView shoppingCartUpdateQty(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("cartForm") CartInfo cartForm) {

		CartInfo cartInfo = Utils.getCartInSession(request);
		cartInfo.updateQuantity(cartForm);

		return new RedirectView("shoppingCart");
	}

	@GetMapping(value = { "/shoppingCartRemoveProduct" })
	public RedirectView removeProduct(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") String code) {
		Product product = null;
		if (code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if (product != null) {
			CartInfo cartInfo = Utils.getCartInSession(request);
			ProductInfo productInfo = new ProductInfo(product);
			cartInfo.removeProduct(productInfo);
		}
		return new RedirectView("shoppingCart");
	}

	@PostMapping(value = { "/shoppingCartConfirmation" })
	public RedirectView shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
		CartInfo cartInfo = Utils.getCartInSession(request);
		if (cartInfo.isEmpty()) {
			return new RedirectView("shoppingCart");
		} else if (!cartInfo.isValidCustomer()) {
			return new RedirectView("shoppingCartCustomer");
		}
		try {
			orderDAO.saveOrder(cartInfo);
		} catch (Exception e) {

			return new RedirectView("shoppingCartConfirmation");
		}

		// Remove Cart from Session. 
		Utils.removeCartInSession(request);

		// Store last cart. 
		Utils.storeLastOrderedCartInSession(request, cartInfo);

		return new RedirectView("shoppingCartFinalized");
	}

	@GetMapping(value = { "/shoppingCartFinalized" })
	public ModelAndView shoppingCartFinalize(HttpServletRequest request, Model model) {

		CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);

		if (lastOrderedCart == null) {
			return new ModelAndView("shoppingCart");
		}
		model.addAttribute("lastOrderedCart", lastOrderedCart);
		return new ModelAndView("shoppingCartFinalize");
	}

	@GetMapping(value = { "/api/orderList" })
	public ModelAndView orderList(Model model, //
			@RequestParam(value = "page", defaultValue = "0") String pageStr) {
		int page = 0;
		try {
			page = Integer.parseInt(pageStr);
		} catch (Exception e) {
		}
		final int MAX_RESULT = 5;

		List<Order> paginationResult = orderDAO.listOrderInfo(page, MAX_RESULT);

		int total = paginationResult.size() / MAX_RESULT;
		if (paginationResult.size() % MAX_RESULT == 0)
			total = paginationResult.size() / MAX_RESULT;
		else
			total = paginationResult.size() / MAX_RESULT + 1;

		model.addAttribute("totalPages", total);
		model.addAttribute("totalRecords", paginationResult.size());
		model.addAttribute("orderInfoList", paginationResult);
		return new ModelAndView("orderList");
	}

	@GetMapping(value = { "/api/order" })
	public ModelAndView orderView(Model model, @RequestParam("orderId") String orderId) {
		Order orderInfo = null;
		if (orderId != null) {
			orderInfo = this.orderDAO.getOrderInfo(orderId);
		}
		if (orderInfo == null) {
			return new ModelAndView("/api/orderList");
		}
		List<OrderDetail> details = this.orderDAO.listOrderDetails(orderId);

		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("orderInfodetails", details);

		return new ModelAndView("order");
	}
}
