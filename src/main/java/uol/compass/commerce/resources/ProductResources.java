package uol.compass.commerce.resources;

import java.util.List;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.repositories.ProductRepository;

public class ProductResources {
  private ProductRepository repository;

  public ProductResources() {
    repository = new ProductRepository();
  }

  public void insertProduct(Product product) {
    repository.insertProduct(product);
    System.out.println("Produto inserido com sucesso!");
  }

  public void displayAllProductsAsJson() {
    String productsJson = repository.getAllProductsAsJson();
    System.out.println(productsJson);
  }

  public List<Product> getAllProducts() {
    return repository.getAllProducts();
  }

  public void updateProductById(Integer id, Product product) {
    if(!productAttributesAreValid(product)) {
      System.out.println("Erro: Atributos inválidos.");
      return;
    }
    
    try {
      Product updatedProduct = repository.updateById(id, product);

      System.out.println("Produto atualizado com sucesso.");
      System.out.printf("{%n   'id': %d,%n   'name': '%s',%n   'description': '%s',%n   'value': %.2f%n}%n",
      updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getValue());
    
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public void deleteProductById(Integer id) {
    try {
      repository.deleteById(id);
      System.out.println("Produto deletado com sucesso.");
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public boolean productAttributesAreValid(Product p) {
    String name = p.getName();
    String description = p.getDescription();
    Double value = p.getValue();

    if (name == null || name.isEmpty() || name.isBlank() || name.length() > 100)
      return false;

    if (description == null || description.isEmpty() || description.isBlank() || description.length() < 10)
      return false;

    if(value == null || value < 0)
      return false;

    return true;
  }
}