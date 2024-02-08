package uol.compass.commerce.dao;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import uol.compass.commerce.entities.Product;

public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insertProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("SELECT p FROM Product p");
        return query.getResultList();
    }

    @Override
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
}
