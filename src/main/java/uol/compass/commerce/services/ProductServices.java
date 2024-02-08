package uol.compass.commerce.services;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.repositories.ProductRepository;

public class ProductServices {
    ProductRepository repository = new ProductRepository();
    
    public Product updateProductById(Integer id, Product product) {
        Product verifProduct = repository.findById(id);

        if(verifProduct == null) {
            return null;
        }

        return repository.updateById(id, product);
    }
}
