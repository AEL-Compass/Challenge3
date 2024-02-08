package uol.compass.commerce.resources;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.services.ProductServices;

public class ProductResources {
    ProductServices service = new ProductServices();

    public void updateProductById(Integer id, Product product) {
        
        if(!productAttributesAreValid(product)) {
            System.out.println("Erro: Atributos inválidos.");
            return;
        }

        Product updatedProduct = service.updateProductById(id, product);

        System.out.printf("{%n   'id': %d,%n   'name': '%s',%n   'description': '%s',%n   'value': %.2f%n}%n",
            updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getValue());
    }

    public boolean productAttributesAreValid(Product p) {
        String name = p.getName();
        String description = p.getDescription();
        Double value = p.getValue();

        if(name == null || name.isEmpty() || name.isBlank() || name.length() > 100)
            return false;

        if(description == null || description.isEmpty() || description.isBlank() || description.length() < 10)
            return false;

        if(value == null || value < 0)
            return false;

        return true;
    }
}
