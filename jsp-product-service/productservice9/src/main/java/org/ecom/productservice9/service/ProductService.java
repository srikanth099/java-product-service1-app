package org.ecom.productservice9.service;

import java.util.List;

import org.ecom.productservice9.entity.Product;
import org.ecom.productservice9.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public double findProductPriceByProductId(@PathVariable("productId")long productId) {
		return productRepository.findProductPriceByProductId(productId);
	}

	public Product createProduct(Product product) {
		return productRepository.createProduct(product);
	}

	public Product getProductById(@PathVariable("alKey") Long id) {
		return productRepository.getProductById(id);
	}

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product saveAllProducts(Product product) {
		return productRepository.saveAllProducts(product);
		
	}

}
