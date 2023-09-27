package manager;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOBinary {
    public static void writeDataToFile(String path, ArrayList<Product> products) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(products);
            fileOut.close();
            objectOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            products = (List<Product>)objectIn.readObject();
            fileIn.close();
            objectIn.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

}
