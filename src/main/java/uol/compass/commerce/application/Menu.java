package uol.compass.commerce.application;

import java.util.Scanner;

import uol.compass.commerce.resources.ProductResource;

public class Menu {

  public static void showMainMenu(Scanner scanner, ProductResource productResource) {
    String opMenu = "";
    int choice = -1; // Começa em -1 para poder aguardar o zero do teclado e não sair do sistema todo
    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|                     MENU                     |");
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|  1 - Produtos                                |");
      System.out.println("|                                              |");
      System.out.println("|  2 - Créditos                                |");
      System.out.println("|                                              |");
      System.out.println("|  0 - Sair                                    |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Informe a opção desejada: ");
      opMenu = scanner.next();
      try{
        choice = Integer.parseInt(opMenu);

        switch (choice) {
          case 0:
            break;
          case 1:
            showProdutosMenu(scanner, productResource);
            break;
          case 2:
            showCreditos(scanner);
            break;
          default:
            showOpcaoInvalida(scanner);
            break;
        }

      } catch (Exception e){
        showOpcaoInvalida(scanner);
  
      }
    } while (choice != 0);
  }

  public static void showProdutosMenu(Scanner scanner, ProductResource productResource) {
    String opMenu = "";
    int choice = -1; // começa em -1 para não sair do menu de produtos caso a primeira tentativa seja inválida
    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|               MENU DE PRODUTOS               |");
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|  1 - Inserir produto                         |");
      System.out.println("|  2 - Exibir todos os produtos em JSON        |");
      System.out.println("|  3 - Buscar Produto por ID                   |");
      System.out.println("|  4 - Atualizar produto por ID                |");
      System.out.println("|  5 - Deletar produto por ID                  |");
      System.out.println("|  0 - Voltar ao menu principal                |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Informe a opção desejada: ");
      opMenu = scanner.next();
      try{
        choice = Integer.parseInt(opMenu);
        switch (choice) {
          case 0:
            break;
          case 1:
            Application.insertProduct(scanner, productResource);
            break;
          case 2:
            Application.getAllProducts(productResource);
            break;
          case 3:
            Application.getProductById(scanner, productResource);
            break;
          case 4:
            Application.updateProductById(scanner, productResource);
            break;
          case 5:
            Application.deleteProductById(scanner, productResource);
            break;
          default:
            showOpcaoInvalida(scanner);
            break;
        }
      }catch (Exception e) {
        showOpcaoInvalida(scanner);
      }
    } while (choice != 0);
  }

  public static void limpaTela(int linhas) {
    for (int i = 0; i < 5; i++)
      System.out.println("");
  }

  public static void showCreditos(Scanner scanner) {
    String opMenu = "";
    int choice = -1;

    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|                   CREDITOS                   |");
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|  Adileny Meneghetti                          |");
      System.out.println("|                                              |");
      System.out.println("|  Emanuel de Lara                             |");
      System.out.println("|                                              |");
      System.out.println("|  Lucas Pacheco                               |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Digite '0' para voltar: ");

      opMenu = scanner.next();
      try {
        choice = Integer.parseInt(opMenu);
        switch (choice) {
          case 0:
            break;
          default:
            showOpcaoInvalida(scanner);
            break;
        }

      } catch( Exception e) {
        showOpcaoInvalida(scanner);
      }
    } while (choice != 0);
  }

  public static void showOpcaoInvalida(Scanner scanner) {
    String opMenu = "";
    int choice = -1;

    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|                OPCAO INVALIDA                |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Digite '0' para voltar  ");

      opMenu = scanner.next();
      
      try {
        choice = Integer.parseInt(opMenu);
        switch (choice) {
          default:
            break;
        }
      } catch (Exception e){}
    } while (choice  != 0);
  }
}
