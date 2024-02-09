package uol.compass.commerce.resources;

import java.util.List;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.services.ProductService;

public class ProductResource {
  private ProductService service;

  public ProductResource() {
    service = new ProductService();
  }

  public Product insertProduct(Product product) {
    if(!productAttributesAreValid(product)) {
      System.out.println("Erro: Atributos inválidos.");
      return null;
    }
    
    try {
      Product insertedProduct = service.insertProduct(product);

      if(insertedProduct == null) {
        System.out.println("Erro: Produto não inserido.");
        return null;
      }

      System.out.println("Produto inserido com sucesso.");
      return insertedProduct;
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
      return null;
    }
  }

  public List<Product> getAllProducts() {
    return service.getAllProducts();
  }

  public Product updateProductById(Integer id, Product product) {
    if(!productAttributesAreValid(product)) {
      System.out.println("Erro: Atributos inválidos.");
      return null;
    }
    
    try {
      Product updatedProduct = service.updateProductById(id, product);

      System.out.println("Produto atualizado com sucesso.");
      return updatedProduct;    
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
      return null;
    }
  }

  public Product getProductById(Integer id) {
    if(id == null || id < 0) {
      System.out.println("Erro: ID inválido.");
      return null;
    }

    return service.getProductById(id);
  }

  public void deleteProductById(Integer id) {
    try {
      service.deleteProductById(id);
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