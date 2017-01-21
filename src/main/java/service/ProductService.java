package service;

import org.springframework.stereotype.Service;

import domain.Product;

@Service
public interface ProductService {
	public void processOrder(String productId, int quantity) ;
	public void addProduct(Product newProduct);
}
