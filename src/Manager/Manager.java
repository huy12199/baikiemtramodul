package Manager;

import Readandwrite.Readandwrite;
import Sort.Sort;
import Validate.Validate;
import models.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    Readandwrite readandwrite = new Readandwrite();

    public void Menu() {
        System.out.println("==MENU==");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        switch (Integer.parseInt(Validate.Choice())) {
            case 1:
                displayProduct(products);
                break;
            case 2:
                addProduct();
                break;
            case 3:
                edit();
                break;
            case 4:
                detele();
                break;
            case 5:
                sort();
                break;
            case 6:
                searchExpensiveProduct();
                break;
            case 7:
                products = readandwrite.reader();
                break;
            case 8:
                readandwrite.write(products);
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("không tìm thấy chức năng trong menu");
        }
    }

    public Product createProduct() {
        System.out.println("nhập mã sản phẩm");
        String id = Validate.validateID(products);
        System.out.println("nhập tên của sản phẩm");
        String name = Validate.namevalidate();
        float price = Validate.valiDatePrice();
        int amount = Validate.valiDateAmount();
        System.out.println("nhập trạng thái của sản phẩm");
        String describe = scanner.nextLine();
        return new Product(id, name, price, amount, describe);
    }

    public void addProduct() {
        products.add(createProduct());
    }

    public void edit() {
        System.out.println("nhập id bạn muốn sửa");
        String id;
        while (true) {
            id = scanner.nextLine();
            if (id.matches("[0-9]{6}")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        int index = Validate.getIndexId(id, products);
        products.set(index, createProduct());
    }

    public void detele() {
        System.out.println("nhập id bạn muốn sửa");
        String id;
        while (true) {
            id = scanner.nextLine();
            if (id.matches("[0-9]{6}")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        int index = Validate.getIndexId(id, products);
        products.remove(index);
    }

    public void sort() {
        products.sort(new Sort());
    }

    public void searchExpensiveProduct() {
        float max = products.get(0).getPrice();
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > max) {
                max = products.get(i).getPrice();
                index = i;
            }
            System.out.println("The most expensive product is: " + products.get(index).getName() + " price: " + max);
        }
    }

    public void displayProduct(ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if ((i + 1) % 5 == 0) {
                scanner.nextLine();
                System.out.println(products.get(i));
            } else
                System.out.println(products.get(i));
        }
    }
}
