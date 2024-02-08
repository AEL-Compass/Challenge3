package uol.compass.commerce;

import java.util.Scanner;

public class Application {

  public static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) {
    showMenu(); // exibe o menu principal
  }

  public static void showMenu() {
    int opMenu = 0;
    // vai desenhar a tela de menu enquanto a opção não for 0;
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
      opMenu = kb.nextInt();
      switch (opMenu) {
        case 0:
          break;
        case 1:
          showListaProdutos();
          break;
        case 2:
          showCreditos();
          break;
        default:
          showOpcaoInvalida();
          break;
      }
    } while (opMenu != 0);
  }

  public static void limpaTela(int linhas) {
    for (int i = 0; i < linhas; i++) System.out.println("");
  }

  public static void showListaProdutos() {
    int opMenu = 0;

    do {
      limpaTela(20);

      // @TODO: Lista de produtos

      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|  1 - Novo                                    |");
      System.out.println("|  2 - Alterar                                 |");
      System.out.println("|  3 - Excluir                                 |");
      System.out.println("|  0 - Voltar                                  |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Informe a opção desejada: ");
      opMenu = kb.nextInt();
      switch (opMenu) {
        case 0:
          break;
        case 1:
          // @TODO novoProduto();
          break;
        case 2:
          // @TODO alteraProduto();
          break;
        case 3:
          // @TODO excluiProduto();
          break;
        default:
          showOpcaoInvalida();
          break;
      }
    } while (opMenu != 0);
  }

  public static void showCreditos() {
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

      String opcao = kb.next();

      opMenu = Integer.parseInt(opcao);
      switch (opMenu) {
        case 0:
          break;
        default:
          showOpcaoInvalida();
          break;
      }
    } while (opMenu != 0);
  }

  public static void showOpcaoInvalida() {
    int opMenu = 0;

    do {
      limpaTela(20);
      System.out.println("------------------------------------------------");
      System.out.println("|                                              |");
      System.out.println("|                OPCAO INVALIDA                |");
      System.out.println("|                                              |");
      System.out.println("------------------------------------------------");
      System.out.print("  Digite '0' para voltar  ");

      String opcao = kb.next();

      opMenu = Integer.parseInt(opcao);
      switch (opMenu) {
        default:
          break;
      }
    } while (opMenu != 0);
  }
}
