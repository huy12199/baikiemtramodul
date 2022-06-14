package Validate;

import models.Product;

import java.util.List;
import java.util.Scanner;

public class Validate {
    public static final String regexname = "[A-Za-z]+";
    public static final String regexid = "[0-9]{6}";
    public static final String regexchoice = "[0-9]+";
    static Scanner scanner = new Scanner(System.in);

    public static String validateID(List<Product> products) {
        while (true) {
            String id = scanner.nextLine();
            if (id.matches(regexid)) {
                try {
                    if (getIndexId(id, products) != -1) {
                        throw new Exception();
                    }
                    return id;
                } catch (Exception e) {
                    System.out.println("id đã tồn tại");
                }
            }
            System.out.println("sai định dạng => nhập lại");
        }
    }

    public static int getIndexId(String id, List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static String namevalidate() {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regexname)) {
                return name;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
    }

    public static String Choice() {
        while (true) {
            String choice = scanner.nextLine();
            if (choice.matches(regexchoice)) {
                return choice;
            } else System.out.println("Chỉ nhập kí tự là số ");
        }
    }

    public static float valiDatePrice (){
        while (true){
            try {
                System.out.println("Nhập giá bán: ");
                Float price = Float.parseFloat(scanner.nextLine());
                if (price <= 0 ) throw new Exception();
                else return price;
            } catch (Exception e) {
                System.out.println("nhập sai dữ liệu nhập lai ");
            }
            System.out.println("nhập sai định rạng");
        }
    }
    public static int valiDateAmount (){
        while (true){
            try {
                System.out.println("Số lượng: ");
                int amount = Integer.parseInt(scanner.nextLine());
                if (amount < 0) throw new Exception();
                else return amount;
            }catch (Exception e) {
                System.out.println(" nhập sai kiểu dữ liệu nhập lại đi ");
            }
        }
    }
}

