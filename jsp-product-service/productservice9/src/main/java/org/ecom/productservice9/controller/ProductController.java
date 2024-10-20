package org.ecom.productservice9.controller;

import java.util.List;

import org.ecom.productservice9.entity.Product;
import org.ecom.productservice9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/findProductPriceByProductId/{productId}")
	public double findProductPriceByProductId(@PathVariable("productId") long productId) {
		System.out.println("productId :" + productId);
		return productService.findProductPriceByProductId(productId);
	}

	@PostMapping(value = "/saveProduct")
	public @ResponseBody Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
		// requestBody==json data to java object convertion
		// responceBody==java Object to json type data
		// why json meance its is independent language
	}

	@GetMapping(value = "/getProduct/{altKey}")
	public Product getProductById(@PathVariable("alKey") Long id) {
		return productService.getProductById(id);
	}

	@GetMapping(value = "/getAllProducts")
	public @ResponseBody List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping(value = "/saveAllProducts")
	public @ResponseBody Product saveAllProducts(Product product) {
		return productService.saveAllProducts(product);

	}

	public void getProductQuantityById(Long id) {

	}

	public void createProducts(List<Product> productList) {

	}

	@GetMapping(value = "/getProductByname")
	public String getProductByname(@RequestParam("name") String name) {
		return name;

	}

	@GetMapping(value = "/getProductInRange")
	public List<Product> getProductInRange(double lowerprice, double highestPrice) {
		return null;

	}
}
