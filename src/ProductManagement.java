import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManagement {
    private static final String FILE_PATH = "product.csv";
    private static final String FILE_PATH1 = "product1.csv";
    private List<Product> products;

    public ProductManagement() {
        this.products = new ArrayList<>();
    }

    public ProductManagement(List<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public Product searchById(int id) {
        for (Product product : products) {
            if (product.getId() == id) ;
            return product;
        }
        return null;
    }

    public Product searchByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void remove(int id) {
        Product product = searchById(id);
        if (product != null) {
            products.remove(product);
        }
    }

    public void sortAscending() {
        ProductComparatorAscending productComparatorAscending = new ProductComparatorAscending();
        products.sort(productComparatorAscending);
    }

    public void sortDecrease() {
        ProductComparatorDecrease productComparatorDecrease = new ProductComparatorDecrease();
        products.sort(productComparatorDecrease);
    }

    public void update(int id, Product newProduct) {
        Product product = searchById(id);
        if (product != null) {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
        }

    }

    @Override
    public String toString() {
        return "ProductManagement{" +
                "products=" + products +
                '}';
    }

    public void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(FILE_PATH);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
    }

    }

    public List<Product> readDataFromFile() {
        List<Product> productArrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productArrayList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return productArrayList;
    }
}