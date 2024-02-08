package uol.compass.commerce.resources;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.services.ProductServices;

public class ProductResources {
    ProductServices service;

    public ProductResources() {
        service = new ProductServices();
    }

    public void updateProductById(Integer id, Product product) {
        
        if(!productAttributesAreValid(product)) {
            System.out.println("Erro: Atributos inválidos.");
            return;
        }
        
        try {
            Product updatedProduct = service.updateProductById(id, product);            

            System.out.println("Produto atualizado com sucesso.");
            System.out.printf("{%n   'id': %d,%n   'name': '%s',%n   'description': '%s',%n   'value': %.2f%n}%n",
            updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getValue());
        
        } catch (Exception e) {
            System.out.println("Erro: Produto não encontrado.%Detalhes: " + e.getMessage());
        }
    }

    public void deleteProductById(Integer id) {
        try {
            service.deleteProductById(id);
            System.out.println("Produto deletado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
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
