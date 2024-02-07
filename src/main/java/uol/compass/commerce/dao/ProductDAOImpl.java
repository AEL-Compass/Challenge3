package uol.compass.commerce.dao;

import jakarta.persistence.EntityManager;
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

}
