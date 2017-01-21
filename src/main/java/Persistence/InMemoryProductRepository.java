package Persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import domain.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository{

	private final Map<String,Product> listOfProduct;

	public InMemoryProductRepository() {
		listOfProduct = new HashMap<String,Product>();
		
		Product product1 = new Product("AP001","IPhone","Apple");
		product1.setUnitPrice(new BigDecimal(30000));
		product1.setUnitsInStock(200);
		
		Product product2 = new Product("AP002","IPad","Apple");
		product2.setUnitPrice(new BigDecimal(10000));
		product2.setUnitsInStock(100);
		
		listOfProduct.put(product1.getProductId(),product1);
		listOfProduct.put(product1.getProductId(),product2);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return new ArrayList<Product>(listOfProduct.values());
	}
	
	@Override
	public Product getProductById(String productId) {
		return listOfProduct.get(productId);
	}
	
	@Override
	public void addProduct(Product newProduct) {
		listOfProduct.put(newProduct.getProductId(), newProduct);
	}

	
}