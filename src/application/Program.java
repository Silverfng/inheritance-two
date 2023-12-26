package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int number = sc.nextInt();

        for (int i=0; i<number ; i++){
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (type == 'c'){
                products.add(new Product(name, price));
            } else if (type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                products.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.println("Customs fee: ");
                double customFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customFee));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : products){
            System.out.println(prod.priceTag());
        }

        sc.close();
    }

}