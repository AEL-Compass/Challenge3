package uol.compass.commerce.application;

import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uol.compass.commerce.entities.Product;

public class Application {

    public static void main(String[] args) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uol.compass.commerce");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Product product = new Product();
        product.setProductName("Copo Stanley");
        product.setProductDescription("Copo para tomar cerveja");

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

    }
    
}
