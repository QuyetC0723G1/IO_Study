package manager;

import model.Product;

import java.util.ArrayList;

public class ProductManager implements IManager<Product> {
    ArrayList<Product> list;
    public ProductManager() {
        list = (ArrayList<Product>) IOBinary.readDataFromFile("product.dat");
    }

    @Override
    public void add(Product product) {
        list.add(product);
        IOBinary.writeDataToFile("product.dat",list);
    }

    @Override
    public void edit(int id) {
        Product product = findById(id);
        if (product != null) {
            list.remove(product);
        } else {
            System.out.println("===>>>> The Id Not Found <<<====" + id);
        }
        IOBinary.writeDataToFile("product.dat",list);
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            list.remove(product);
            System.out.println("====>> Remove Successfully <<====");
        } else {
            System.out.println("===>>>> Not Found <<<====" + id);
        }
        IOBinary.writeDataToFile("product.dat",list);
    }

    @Override
    public ArrayList<Product> findAll() {
        return list;
    }

    @Override
    public Product findById( int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> findByName(String s) {
        ArrayList<Product> newList = new ArrayList<>();
        for (Product product: list) {
            if (product.getName().toLowerCase().contains(s.toLowerCase())){
                newList.add(product);
            }
        }return newList;
    }


}
