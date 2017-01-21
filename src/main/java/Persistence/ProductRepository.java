package Persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import domain.Product;

@Repository
public interface ProductRepository {
	public List<Product> getAllProducts();
	public Product getProductById(String productId);
	public void addProduct(Product newProduct);
}
