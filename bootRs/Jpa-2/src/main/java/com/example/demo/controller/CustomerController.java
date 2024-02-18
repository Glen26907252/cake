package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vo.CartInfo;
import com.example.demo.vo.CustomerForm;
import com.example.demo.vo.CustomerInfo;
import com.example.demo.util.Utils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CustomerController {
	 // GET: Enter customer information.
	   @GetMapping(value = { "/shoppingCartCustomer" })
	   public ModelAndView shoppingCartCustomerForm(HttpServletRequest request, Model model) {
	 
	      CartInfo cartInfo = Utils.getCartInSession(request);
	 
	      if (cartInfo.isEmpty()) {	 
	         return new ModelAndView("shoppingCart");
	      }
	      CustomerInfo customerInfo = cartInfo.getCustomerInfo();	 
	      CustomerForm customerForm = new CustomerForm(customerInfo);	 
	      model.addAttribute("customerForm", customerForm);	 
	      return new ModelAndView("customer");
	   }
	 
	   // POST: Save customer information.
	   @PostMapping(value = { "/shoppingCartCustomer" })
	   public ModelAndView shoppingCartCustomerSave(HttpServletRequest request, //
	         Model model, //
	         @ModelAttribute("customerForm") CustomerForm customerForm, //
	         BindingResult result) {
	 
	      if (result.hasErrors()) {
	         customerForm.setValid(false);
	         // Forward to reenter customer info.
	         return new ModelAndView("shoppingCartCustomer");
	      }
	 
	      customerForm.setValid(true);
	      CartInfo cartInfo = Utils.getCartInSession(request);
	      CustomerInfo customerInfo = new CustomerInfo(customerForm);
	      cartInfo.setCustomerInfo(customerInfo);
	      model.addAttribute("myCart", cartInfo);
	      return new ModelAndView("shoppingCartConfirmation");
	   }	 
}

