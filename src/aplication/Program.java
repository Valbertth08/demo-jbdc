package aplication;

import model.entites.Department;
import model.entites.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1,"Books");
        System.out.println(obj);
        Seller seller = new Seller(21,"bob","bob@gmail.com",new Date(),3000.00,obj);
        System.out.println(seller);
    }
}
