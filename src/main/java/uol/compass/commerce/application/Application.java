package uol.compass.commerce.application;

import java.sql.SQLException;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uol.compass.commerce.dao.ProductDAO;
import uol.compass.commerce.dao.ProductDAOImpl;
import uol.compass.commerce.entities.Product;

public class Application {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductDAO productDAO;
    private static Scanner scanner;

    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("uol.compass.commerce");
        entityManager = entityManagerFactory.createEntityManager();
        productDAO = new ProductDAOImpl(entityManager);
        scanner = new Scanner(System.in);

        // Menu interativo
        int choice = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Inserir produto");
            System.out.println("2. Exibir todos os produtos em JSON");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertProductFromInput();
                    break;
                case 2:
                    displayAllProductsAsJson();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (choice != 3);

        // Fechando o scanner
        scanner.close();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void insertProductFromInput() {
        Product product = new Product();
        scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()
        
        System.out.print("Nome do produto: ");
        product.setProductName(scanner.nextLine());

        System.out.print("Código do produto: ");
        product.setProductCode(scanner.nextLine());

        System.out.print("Modelo: ");
        product.setModel(scanner.nextLine());

        System.out.print("Cor: ");
        product.setColor(scanner.nextLine());

        System.out.print("Capacidade: ");
        product.setCapacity(scanner.nextLine());

        System.out.print("Status (Disponível/Indisponível): ");
        product.setStatus(scanner.nextLine());

        System.out.print("Quantidade: ");
        product.setQuantity(scanner.nextInt());

        System.out.print("Preço: ");
        product.setPrice(scanner.nextDouble());

        // Inserir o produto no banco de dados
        productDAO.insertProduct(product);
        System.out.println("Produto inserido com sucesso!");
    }

    public static void displayAllProductsAsJson() {
        String productsJson = productDAO.getAllProductsAsJson();
        System.out.println(productsJson);
    }
}