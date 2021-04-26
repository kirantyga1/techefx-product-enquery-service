package com.techefx.microservices.productenqueryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techefx.microservices.productenqueryservice.beans.ProductEnquiryBean;
import com.techefx.microservices.productenqueryservice.client.ProductStockClient;

@RestController
public class ProductEnqueryController {

	@Autowired
	ProductStockClient client;

	@GetMapping("/productenquiry/name/{name}/availability/{availability}/unit/{unit}")
	public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name, 
												  @PathVariable String availability,
												  @PathVariable int unit) {
			
		
		ProductEnquiryBean productEnquiryBean=client.checkProductStock(name, availability);
		
		double totalPrice=productEnquiryBean.getProductPrice()*unit;
		double discounts=productEnquiryBean.getDiscountOffer();
		double discountPrice=	(totalPrice-discounts)/100;
				
		return new ProductEnquiryBean(productEnquiryBean.getId(), name,
				productEnquiryBean.getProductPrice(), availability,
				productEnquiryBean.getDiscountOffer(), unit, totalPrice,
				productEnquiryBean.getPort()
									
				);
		
	}
}
