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

  public Product insertProduct(Product product) {
    try {
      if (!transaction.isActive()) {
        transaction.begin();
        entityManager.persist(product);
        entityManager.flush();
        transaction.commit();
      }
      return product;
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      return null;
    }
  }

  public List<Product> getAllProducts() {
    return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
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
    entityManager.flush();
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