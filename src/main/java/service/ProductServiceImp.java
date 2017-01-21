package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Persistence.ProductRepository;
import domain.Product;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void processOrder(String productId, int quantity) {
	
		Product orderdProduct = productRepository.getProductById(productId);
		if (orderdProduct != null) {
			if (quantity < orderdProduct.getUnitsInStock()) {
				orderdProduct.setUnitsInStock(orderdProduct.getUnitsInStock() - quantity);
			} else {
				throw new IllegalArgumentException("Illegal Exception");
			}
		}
	}
	
	@Override
	public void addProduct(Product newProduct) {
		productRepository.addProduct(newProduct);
	}

}
