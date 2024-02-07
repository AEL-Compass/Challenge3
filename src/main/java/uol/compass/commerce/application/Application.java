package uol.compass.commerce.application;

import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uol.compass.commerce.dao.ProductDAO;
import uol.compass.commerce.dao.ProductDAOImpl;
import uol.compass.commerce.entities.Product;

public class Application {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductDAO productDAO;

    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("uol.compass.commerce");
        entityManager = entityManagerFactory.createEntityManager();
        productDAO = new ProductDAOImpl(entityManager);

        //showMenu();
    }

    public static void insertProduct(Product product) {
        productDAO.insertProduct(product);
    }

}
