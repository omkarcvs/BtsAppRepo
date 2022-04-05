package com.app.bts.entity.common;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

	public Product find() {
		return new Product("p01", "name 1", 20);
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name 1", 20));
		products.add(new Product("p02", "name 2", 21));
		products.add(new Product("p03", "name 3", 22));
		return products;
	}
}

