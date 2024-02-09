package uol.compass.commerce.services;

import java.util.List;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.repositories.ProductRepository;

public class ProductService {
  ProductRepository repository;

  public ProductService() {
    repository = new ProductRepository();
  }

  public Product insertProduct(Product product) {
    return repository.insertProduct(product);
  }

  public List<Product> getAllProducts() {
    return repository.getAllProducts();
  }

  public Product getProductById(Integer id) {
    return repository.findById(id);
  }
  
  public Product updateProductById(Integer id, Product product) {
    Product verifyProduct = repository.findById(id);

    if(verifyProduct == null) {
      throw new RuntimeException("Produto não encontrado.");
    }
    return repository.updateById(id, product);
  }

  public void deleteProductById(Integer id) {
    Product verifyProduct = repository.findById(id);

    if(verifyProduct == null) {
      throw new RuntimeException("Produto não encontrado.");
    }

    repository.deleteById(id);
  }
}