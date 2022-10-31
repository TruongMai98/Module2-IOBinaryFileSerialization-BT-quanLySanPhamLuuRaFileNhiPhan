import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class ProductManagementMenu {
    ProductManagement productManagement = new ProductManagement();
    public void displayMenu() {
        System.out.println("======== Menu =======");
        System.out.println("1. Add new data");
        System.out.println("2. Update data");
        System.out.println("3. Delete data");
        System.out.println("4. Search by id");
        System.out.println("5. Sort decrease with price");
        System.out.println("6. Sort ascending with price");
        System.out.println("7. Display all");
        System.out.println("8. Save file");
        System.out.println("9. Read file");
        System.out.println("0. Exit");
    }

    public void menu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Pls choose number");
            int choose = scanner.nextInt();
            scanner.hasNextLine();

            switch (choose) {
                case 1:
                    productManagement.add(scannerProduct(scanner));
                    break;
                case 2:
                    Product productUpdate = scannerProduct(scanner);
                    productManagement.update(productUpdate.getId(), productUpdate);
                    break;
                case 3:
                    System.out.println("Input id wanna remove");
                    int idRemove = scanner.nextInt();
                    productManagement.remove(idRemove);
                    break;
                case 4:
                    System.out.println("Input id wanna search");
                    int idSearch = scanner.nextInt();
                    System.out.println(productManagement.searchById(idSearch));
                    break;
                case 5:
                    productManagement.sortDecrease();
                    System.out.println(productManagement);
                    break;
                case 6:
                    productManagement.sortAscending();
                    System.out.println(productManagement);
                    break;
                case 7:
                    System.out.println(productManagement);
                    break;
                case 8:
                    saveFile();
                    break;
                case 9:
                    readFile();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void readFile() {
        productManagement.readDataFromFile();
    }

    private void saveFile() {
        productManagement.saveFile();
    }

    public static Product scannerProduct(Scanner scanner) {
        System.out.println("Input id");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Input name");
        String name = scanner.nextLine();
        

        System.out.println("Input price");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product(id, name, price);
        return product;
    }
}