package uol.compass.commerce.repositories;

// import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import uol.compass.commerce.entities.Product;

public class ProductRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public ProductRepository() {
        entityManager = PersistenceManager.getEntityManager();
        transaction = entityManager.getTransaction();
    }

    // public Product insert(Product product) {
    //     entityManager.getTransaction().begin();
    //     entityManager.persist(product);
    //     entityManager.getTransaction().commit();

    //     return product;
    // }

    // public List<Product> findAll() {
    //     // Retorna a lista ou vazio
    //     return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    // }

    public Product findById(Integer id) {
        // Retorna o produto ou nulo
        return entityManager.find(Product.class, id);
    }

    public Product findByName(String name) {
        // Retorna o produto ou nulo
        return entityManager.find(Product.class, name);
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

        // Vai lançar uma exceção se ocorrer algum erro, adicionar tratamento em resources
    }
}
