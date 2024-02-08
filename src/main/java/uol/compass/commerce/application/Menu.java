package uol.compass.commerce.application;

import java.util.Scanner;

import uol.compass.commerce.resources.ProductResources;

public class Menu {

  public static void showMainMenu(Scanner scanner, ProductResources productResources) {
    int choice = 0;
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
      choice = scanner.nextInt();

      switch (choice) {
        case 0:
          break;
        case 1:
          showProdutosMenu(scanner, productResources);
          break;
        case 2:
          showCreditos(scanner);
          break;
        default:
          showOpcaoInvalida(scanner);
          break;
      }
    } while (choice != 0);
  }

  public static void showProdutosMenu(Scanner scanner, ProductResources productResources) {
    int choice = 0;
    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|               MENU DE PRODUTOS                |");
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|  1 - Inserir produto                         |");
      System.out.println("|  2 - Exibir todos os produtos em JSON        |");
      System.out.println("|  3 - Atualizar produto por ID                |");
      System.out.println("|  4 - Deletar produto por ID                  |");
      System.out.println("|  0 - Voltar ao menu principal                |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Informe a opção desejada: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 0:
          break;
        case 1:
          Application.insertProductFromInput(scanner, productResources);
          break;
        case 2:
          Application.displayAllProductsAsJson(productResources);
          break;
        case 3:
          Application.updateProductById(scanner, productResources);
          break;
        case 4:
          Application.deleteProductById(scanner, productResources);
          break;
        default:
          showOpcaoInvalida(scanner);
          break;
      }
    } while (choice != 0);
  }

  public static void limpaTela(int linhas) {
    for (int i = 0; i < linhas; i++)
      System.out.println("");
  }

  public static void showCreditos(Scanner scanner) {
    int opMenu = 0;

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
      System.out.print("  Digite '0' para voltar  ");

      String opcao = scanner.next();

      opMenu = Integer.parseInt(opcao);
      switch (opMenu) {
        case 0:
          break;
        default:
          showOpcaoInvalida(scanner);
          break;
      }
    } while (opMenu != 0);
  }

  public static void showOpcaoInvalida(Scanner scanner) {
    int opMenu = 0;

    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|                OPCAO INVALIDA                |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Digite '0' para voltar  ");

      String opcao = scanner.next();

      opMenu = Integer.parseInt(opcao);
      switch (opMenu) {
        default:
          break;
      }
    } while (opMenu != 0);
  }
}