package uol.compass.commerce.services;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.repositories.ProductRepository;

public class ProductServices {
    ProductRepository repository;

    public ProductServices() {
        repository = new ProductRepository();
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
