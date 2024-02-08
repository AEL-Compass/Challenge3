package uol.compass.commerce.application;

import java.util.Scanner;

import uol.compass.commerce.entities.Product;
import uol.compass.commerce.resources.ProductResources;

public class Application {

  public static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) {
    showMenu(); // exibe o menu principal
  }

  public static void showMenu() {
    int opMenu = 0;
    ProductResources productResources = new ProductResources();

    // vai desenhar a tela de menu enquanto a opção não for 0;
    do {
      Menu.showMainMenu(kb, productResources);
    } while (opMenu != 0);
  }

  public static void insertProductFromInput(Scanner scanner, ProductResources productResources) {
    Product product = new Product();
    scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()
    
    System.out.print("Nome do produto: ");
    product.setName(scanner.nextLine());

    System.out.print("Descrição do produto: ");
    product.setDescription(scanner.nextLine());

    System.out.print("Preço: ");
    product.setValue(scanner.nextDouble());

    // Inserir o produto
    productResources.insertProduct(product);
  }

  public static void displayAllProductsAsJson(ProductResources productResources) {
    productResources.displayAllProductsAsJson();
  }

  public static void updateProductById(Scanner scanner, ProductResources productResources) {
    System.out.print("ID do produto a ser atualizado: ");
    int id = scanner.nextInt();
    Product product = new Product();
    scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()
    
    System.out.print("Novo nome do produto: ");
    product.setName(scanner.nextLine());

    System.out.print("Nova descrição do produto: ");
    product.setDescription(scanner.nextLine());

    System.out.print("Novo preço: ");
    product.setValue(scanner.nextDouble());

    productResources.updateProductById(id, product);
  }

  public static void deleteProductById(Scanner scanner, ProductResources productResources) {
    System.out.print("ID do produto a ser deletado: ");
    int id = scanner.nextInt();

    productResources.deleteProductById(id);
  }
}
