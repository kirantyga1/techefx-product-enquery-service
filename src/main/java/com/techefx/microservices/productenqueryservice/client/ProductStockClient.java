package com.techefx.microservices.productenqueryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techefx.microservices.productenqueryservice.beans.ProductEnquiryBean;

//@FeignClient(name="techefx-product-stock-service", url="localhost:8800")
@FeignClient(name = "techefx-product-stock-service")
public interface ProductStockClient {

	@GetMapping(value = "/{productName}/{productAvailability}")
	public ProductEnquiryBean checkProductStock(@PathVariable String productName,
			@PathVariable String productAvailability);

}
