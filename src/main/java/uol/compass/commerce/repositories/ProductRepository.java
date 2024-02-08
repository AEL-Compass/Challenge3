package uol.compass.commerce.repositories;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import uol.compass.commerce.entities.Product;

public class ProductRepository {

  private EntityManager entityManager;
  private EntityTransaction transaction;

  public ProductRepository() {
    entityManager = PersistenceManager.getEntityManager();
    transaction = entityManager.getTransaction();
  }

  public void insertProduct(Product product) {
    try {
      if (!transaction.isActive()) {
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
      }
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public List<Product> getAllProducts() {
    Query query = entityManager.createQuery("SELECT p FROM Product p");
    return query.getResultList();
  }

  public String getAllProductsAsJson() {
    List<Product> productList = getAllProducts();
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.writeValueAsString(productList);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Product findById(Integer id) {
    return entityManager.find(Product.class, id);
  }

  public Product updateById(Integer id, Product product) {
    transaction.begin();
    Product productToUpdate = entityManager.find(Product.class, id);
    productToUpdate.setName(product.getName());
    productToUpdate.setDescription(product.getDescription());
    productToUpdate.setValue(product.getValue());
    transaction.commit();
    return productToUpdate;
  }

  public void deleteById(Integer id) {
    transaction.begin();
    Product product = entityManager.find(Product.class, id);
    entityManager.remove(product);
    transaction.commit();
  }
}