package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.vo.CartInfo;
import com.example.demo.vo.CartLineInfo;
import com.example.demo.vo.CustomerInfo;

@Service
public class OrderDAO {
	@Autowired
	OrderDetailRepository detailsRepo;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	ProductDAO productDAO;

	private int getMaxOrderNum() {
		List<Order> orders = orderRepo.findAll();
		Optional<Integer> maxOrderNumber = orders.stream().map(Order::getOrderNum) // 提取 orderNumber 欄位
				.max(Integer::compareTo); // 找出最大值

		if (maxOrderNumber.isPresent()) {
			return maxOrderNumber.get();
		}
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveOrder(CartInfo cartInfo) {

		int orderNum = this.getMaxOrderNum() + 1;
		Order order = new Order();

		order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum);
		order.setOrderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());

		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		order.setCustomerName(customerInfo.getName());
		order.setCustomerEmail(customerInfo.getEmail());
		order.setCustomerPhone(customerInfo.getPhone());
		order.setCustomerAddress(customerInfo.getAddress());

		orderRepo.save(order);

		List<CartLineInfo> lines = cartInfo.getCartLines();

		for (CartLineInfo line : lines) {
			OrderDetail detail = new OrderDetail();
			detail.setId(UUID.randomUUID().toString());
			detail.setOrder(order);
			detail.setAmount(line.getAmount());
			detail.setPrice(line.getProductInfo().getPrice());
			detail.setQuanity(line.getQuantity());

			String code = line.getProductInfo().getCode();
			Product product = this.productDAO.findProduct(code);
			detail.setProduct(product);

			detailsRepo.save(detail);
		}

		// Order Number!
		cartInfo.setOrderNum(orderNum);

	}

	public List<Order> listOrderInfo(Integer page, Integer maxResult) {

		Pageable paging = PageRequest.of(page, maxResult, Sort.by("OrderDate"));
		Page<Order> pagedResult = orderRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Order>();
		}

	}

	public Order getOrderInfo(String orderId) {

		Optional<Order> order = orderRepo.findById(orderId);
		if (order.isPresent())
			return order.get();
		else
			return null;

	}

	public List<OrderDetail> listOrderDetails(String orderId) {
		List<OrderDetail> data = detailsRepo.findAll().stream()
				.filter(d -> d.getOrder().getId().equals(orderId)).toList();
		return data;
	}
}



