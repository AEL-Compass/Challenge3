package uol.compass.commerce.dao;

import java.util.List;

import uol.compass.commerce.entities.Product;

public interface ProductDAO {
    void insertProduct(Product product);
    List<Product> getAllProducts();
    String getAllProductsAsJson();
}
