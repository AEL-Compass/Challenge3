package uol.compass.commerce.application;

import java.util.List;
import java.util.Scanner;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.resources.ProductResource;

public class Application {

  private static final Scanner kb = new Scanner(System.in);

  public static void main(String[] args) {
    showMenu(); // exibe o menu principal
  }

  public static void showMenu() {
    int opMenu = 0;
    ProductResource productResources = new ProductResource();

    // vai desenhar a tela de menu enquanto a opção não for 0;
    do {
      Menu.showMainMenu(kb, productResources);
    } while (opMenu != 0);
  }

  public static void insertProduct(Scanner scanner, ProductResource productResources) {
    Product product = new Product();
    scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()
    try{

      System.out.print("Nome do produto: ");
      product.setName(scanner.nextLine());
      System.out.print("Descrição do produto: ");
      product.setDescription(scanner.nextLine());
      System.out.print("Preço: ");
      product.setValue(scanner.nextDouble());
  
      // Inserir o produto
      Product inserted = productResources.insertProduct(product);
      
      if(inserted == null) {
        return;
      }
  
      printProductAsJson(inserted, false);
    } catch (Exception e){
      System.out.println("Informacoes invalidas!");
    }
  }

  public static void getAllProducts(ProductResource productResources) {
    List<Product> products = productResources.getAllProducts();

    System.out.println("[");
    for (int i = 0; i < products.size(); i++) {
      printProductAsJson(products.get(i), true);
      if(i < products.size() - 1) {
        System.out.println(",");
      }
    }
    System.out.printf("%n]");
  }

  public static void getProductById(Scanner scanner, ProductResource productResources) {
    System.out.print("ID do produto: ");
    int id = scanner.nextInt();
    Product product = productResources.getProductById(id);

    if(product == null) {
      System.out.println("Produto não encontrado.");
      return;
    }

    printProductAsJson(product, false);
  }

  public static void updateProductById(Scanner scanner, ProductResource productResources) {
    System.out.print("ID do produto a ser atualizado: ");
    int id = scanner.nextInt();
    Product product = productResources.getProductById(id);

    if(product == null) {
      System.out.println("Produto não encontrado.");
      return;
    }
    
    scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()
    try{
      Product toUpdate = new Product();
      System.out.print("Nome do produto(" + product.getName() + "): ");
      toUpdate.setName(scanner.nextLine());
      System.out.print("Descrição do produto(" + product.getDescription() + "): ");
      toUpdate.setDescription(scanner.nextLine());
      System.out.print("Novo preço(" + product.getValue() + "): ");
      toUpdate.setValue(scanner.nextDouble());
  
      Product updated = productResources.updateProductById(id, toUpdate);
      
      if(updated == null) {
        return;
      }  
      printProductAsJson(updated, false);
  
    } catch (Exception e) {
      System.out.println("Informções inválidas!");
    }
  }

  public static void deleteProductById(Scanner scanner, ProductResource productResources) {
    System.out.print("ID do produto a ser deletado: ");
    int id = scanner.nextInt();

    productResources.deleteProductById(id);
  }

  public static void printProductAsJson(Product product, boolean isList) {
    if (isList) {      
      System.out.printf("   {%n      'id': %d,%n      'name': '%s',%n      'description': '%s',%n      'value': %.2f%n   }", product.getId(), product.getName(), product.getDescription(), product.getValue());
    } else {
      System.out.printf("{%n   'id': %d,%n   'name': '%s',%n   'description': '%s',%n   'value': %.2f%n}", product.getId(), product.getName(), product.getDescription(), product.getValue());
    }
  }
}
