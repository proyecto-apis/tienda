package com.scriptkiddie.cmsshoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scriptkiddie.cmsshoppingcart.models.ProductRepository;
import com.scriptkiddie.cmsshoppingcart.models.data.Product;


@RestController
@RequestMapping(path = "/products", produces = "application/json")
public class ProductsRestController {
	@Autowired
	ProductRepository productRepo;
	@GetMapping("/all")
	public Iterable<Product> pages() {
		List <Product> products = productRepo.findAll();
		return products;
	}
	
	@GetMapping("/{id}")
	public Product page(@PathVariable int id){
		List<Product> products = productRepo.findAll();
		Product product = new Product();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getId() == id) {
				product = products.get(i);
			}
		}
		return product;
	}
}
