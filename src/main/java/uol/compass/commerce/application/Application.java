package uol.compass.commerce.application;

import java.sql.SQLException;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uol.compass.commerce.dao.ProductDAO;
import uol.compass.commerce.dao.ProductDAOImpl;
import uol.compass.commerce.entities.Product;
import uol.compass.commerce.resources.ProductResources;

public class Application {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductDAO productDAO;
    private static Scanner scanner;
    private static ProductResources productResources;

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
            System.out.println("3. Atualizar produto por ID");
            System.out.println("4. Deletar produto por ID");
            System.out.println("5. Sair");
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
                    updateProductById();
                    break;
                case 4:
                    // deleteProductById();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (choice != 5);

        // Fechando o scanner
        scanner.close();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void insertProductFromInput() {
        Product product = new Product();
        scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()
        
        System.out.print("Nome do produto: ");
        product.setName(scanner.nextLine());

        System.out.print("Descrição do produto: ");
        product.setDescription(scanner.nextLine());

        System.out.print("Preço: ");
        product.setValue(scanner.nextDouble());

        // Inserir o produto no banco de dados
        productDAO.insertProduct(product);
        System.out.println("Produto inserido com sucesso!");
    }

    public static void displayAllProductsAsJson() {
        String productsJson = productDAO.getAllProductsAsJson();
        System.out.println(productsJson);
    }

    public static void updateProductById() {
        productResources = new ProductResources();
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

        // Atualizar o produto no banco de dados
        productResources.updateProductById(id, product);
    }
}