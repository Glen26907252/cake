package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductDAO;
import com.example.demo.vo.ProductForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@RestController
public class ProductController implements CommandLineRunner {

	@Autowired
	ProductDAO productDAO;

	@GetMapping(value = { "/productList" })
	public ModelAndView listProductHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "Code") String sortName,
			@RequestParam(value = "page", defaultValue = "0") int pageNo) {
		final int maxSize = 3;
		int total = productDAO.getAllProducts() != null ? productDAO.getAllProducts().size() : 0;
		int remain = total % maxSize;
		int pages = total / maxSize;
		int[] pageArray = null;
		if (total == 0)
			pages = 0;
		else {
			if (remain > 0)
				pages++;
			pageArray = new int[pages];
			for (int i = 0; i < pages; i++)
				pageArray[i] = i;
		}

		List<Product> result = productDAO.getPageProducts(pageNo, maxSize, sortName);
		model.addAttribute("paginationProducts", result);
		model.addAttribute("productsTotalPage", pages);
		model.addAttribute("pageArray", pageArray);
		return new ModelAndView("productList");
	}

	@GetMapping(value = { "/api/product" })
	public ModelAndView product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
		ProductForm productForm = null;
		if (code != null && code.length() > 0) {
			Product product = productDAO.findProduct(code);
			if (product != null) {
				productForm = new ProductForm(product);
			}
		}
		if (productForm == null) {
			productForm = new ProductForm();
			productForm.setNewProduct(true);
		}
		model.addAttribute("productForm", productForm);
		ModelAndView mv = new ModelAndView("product");
		return mv;
	}

	@PostMapping(value = { "/api/product" })
	public ModelAndView productSave(Model model, @ModelAttribute("productForm") ProductForm productForm) {

		Product product = null;
		product = new Product();
		product.setCreateDate(new Date());
		product.setCode(productForm.getCode());
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		try {
			if (productForm.getFileData() != null) {
				byte[] image = null;
				try {
					image = productForm.getFileData().getBytes();
				} catch (IOException e) {
				}
				if (image != null && image.length > 0) {
					product.setImage(image);
				}
			}
			productDAO.save(product);
		} catch (Exception e) {
			String message = e.getMessage();
			model.addAttribute("errorMessage", message);

		}
		model.addAttribute("productForm", productForm);
		return new ModelAndView("product");
	}

	@GetMapping(value = { "/productImage" })
	public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("code") String code) throws IOException {
		Product product = null;
		if (code != null) {
			product = this.productDAO.findProduct(code);
		}
		if (product != null && product.getImage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImage());
		}
		response.getOutputStream().close();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String[] surl = { "http://localhost:8080/images/p1.jpg", "http://localhost:8080/images/p2.jpg",
				"http://localhost:8080/images/p3.jpg", "http://localhost:8080/images/vitaminB.jpg",
				"http://localhost:8080/images/vitaminBC.jpg", "http://localhost:8080/images/vitaminE.jpg",
				"http://localhost:8080/images/vitaminKD.jpg" };
		String[] code= {"P01","P02","P03","P04","P05","P06","P07"};
		String[] names= {"EarBuds","USB-HD","ASUS Laptop","VitaminB","VitaminBC","VitaminE","VitaminKD"};
		for (int i = 0; i < surl.length; i++) {
			URL url = new URL(surl[i]);
			InputStream is = url.openConnection().getInputStream();
			byte[] bt = is.readAllBytes();
			Product p1 = new Product();
			p1.setCode(code[i]);
			p1.setImage(bt);
			p1.setName(names[i]);
			p1.setPrice(100);
			p1.setCreateDate(new Date());
			productDAO.save(p1);
		}
	}
}

