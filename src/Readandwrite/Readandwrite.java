package Readandwrite;

import models.Product;

import java.io.*;
import java.util.ArrayList;

public class Readandwrite {
    public void write(ArrayList<Product> products) {
        File file = new File("product.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product hs : products) {
                bufferedWriter.write(hs.write());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Product> reader() {
        ArrayList<Product> products = new ArrayList<>();
        File file = new File("product.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str!=null) {
                {
                    String[] arr = str.split(",");
                    String id = arr[0];
                    String name = arr[1];
                    float price = Float.parseFloat(arr[2]);
                    int amount = Integer.parseInt(arr[3]);
                    String describe = arr[4];
                    products.add(new Product(id, name, price, amount, describe));
                }
                str = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
