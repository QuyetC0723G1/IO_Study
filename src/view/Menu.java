package view;

import manager.IOBinary;
import manager.ProductManager;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
   static Scanner scannerNumber = new Scanner(System.in);
   static Scanner scannerString = new Scanner(System.in);
   static ProductManager productManager = new ProductManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Product drink = new Product(101,"Coca",10000,"Coca Cola","Fresh And Cold");
//        Product food = new Product(102,"Hao Hao",20000,"Ajinomoto","Smooth Noodle");
//        Product tobaco = new Product(103,"Vina",25000,"Vinataba","Full Smoke");
//        productManager.add(drink);
//        productManager.add(food);
//        productManager.add(tobaco);
        showMenu();
    }

    public static void showMenu(){
        int choice;
        do {
            try {
                System.out.println("\n========== Menu Product ===========");
                System.out.println("\t\t1.Add New Product \n\t\t2.Edit Product \n\t\t3.Delete Product \n\t\t4.Find Product By Name \n\t\t5.Show All \n\t\t6.Exit");
                System.out.println("Enter Your Choice : ");
                choice = scannerNumber.nextInt();
                switch (choice) {
                    case 1:
                        showAddMenu();
                        break;
                    case 2:
                        showEdit();
                        break;
                    case 3:
                        removeProduct();
                        break;
                    case 4:
                        findProductByName();
                        break;
                    case 5:
                        showAllMenu();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Enter Number 1 To 5");
                scannerNumber.nextLine();
            }
        }while (true);
    }

    public static void showAddMenu(){
        System.out.println("Enter Id Of New Product : ");
        int id = scannerNumber.nextInt();
        System.out.println("Enter Product Name : ");
        String name = scannerString.nextLine();
        System.out.println("Enter Product Price : ");
        int price = scannerNumber.nextInt();
        System.out.println("Enter Manufacturer Of Product : ");
        String manufacturer = scannerString.nextLine();
        System.out.println("Enter Product Describe : ");
        String describe = scannerString.nextLine();
        Product newProduct = new Product(id,name,price,manufacturer,describe);
        productManager.add(newProduct);
        System.out.println("====> Added Successfully <=====");
    }
    public static Product getInfo(){
        System.out.println("Enter New Id : ");
        int id = scannerNumber.nextInt();
        System.out.println("Enter New Name : ");
        String name = scannerString.nextLine();
        System.out.println("Enter New Price : ");
        int price = scannerNumber.nextInt();
        System.out.println("Enter Manufacturer Of Product : ");
        String manufacturer = scannerString.nextLine();
        System.out.println("Enter Product Describe : ");
        String describe = scannerString.nextLine();
        Product newProduct = new Product(id,name,price,manufacturer,describe);
        System.out.println("====>>> Added Successfully <<<=====");
        return newProduct;
    }

    public static void showEdit(){
        System.out.println("Enter Id Product");
        int id = scannerNumber.nextInt();
       productManager.edit(id);
       productManager.add(getInfo());
    }
    public static void removeProduct(){
        System.out.println("Enter Id Product");
        int id = scannerNumber.nextInt();
        productManager.remove(id);
    }
    public static void findById(){
        System.out.println("Enter Id Product");
        int id = scannerNumber.nextInt();
        Product product = productManager.findById(id);
        if (product != null){
            System.out.println(product);
        }else {
            System.out.println("=====> Not Found <=====");
        }
    }
    public static void findProductByName(){
        System.out.println("Enter Student Name : ");
        String nameProduct = scannerString.nextLine();
        ArrayList<Product> productCheck = productManager.findByName(nameProduct);
        if (!productCheck.isEmpty()){
            System.out.println("\nSearch Result : ");
            for (Product product: productCheck) {
                System.out.println(product);
            }
        }
        else {
            System.out.println(" ===>> Not Found <====");
        }
    }

    public static void showAllMenu(){
        System.out.println("List Product is : ");
        for (Product product: productManager.findAll()) {
            System.out.println(product);
        }
    }
}
