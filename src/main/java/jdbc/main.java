package jdbc;

import jdbc.DAO.DepartmentDAO;
import jdbc.DAO.SellerDAO;
import jdbc.entities.Seller;
import jdbc.exceptions.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.List;

public class main {

/*     A JDBC exige a instalação de um driver para o tipo de banco de dados específico a ser usado.
     Neste exemplo foi usado o mySQL, portanto foi instalado o MySQL connector.*/

    static DepartmentDAO departmentDAO = new DepartmentDAO();
    static SellerDAO sellerDAO = new SellerDAO();
    public static void main(String[] args) {
//        listDepartment();
//        insertSeller();
//        updateSalary();
//        deleteSeller();
//        findById();
//        findAll();
    }

    public static void insertSeller() {
        Seller seller = mockSeller();

        int rowsAffected = sellerDAO.insertSeller(seller);
        System.out.println("rows affected: " + rowsAffected);
    }

    public static void listDepartment() {

        LinkedHashSet<String> results = departmentDAO.listDepartments();
        results.forEach(item -> {
            System.out.println(item);
        });
    }

    public static Seller mockSeller() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return new Seller("Joao",
                    "joao@email.com",
                    new Date(sdf.parse("15/12/2000").getTime()),
                    5000.0,
                    1);
        } catch (ParseException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void updateSalary() {
        sellerDAO.updateSellerSalary(7, 15000.0);
    }

    public static void deleteSeller() {
        sellerDAO.deleteSeller(7);
    }

    public static void findById() {
        System.out.println(sellerDAO.findById(6));
    }

    public static void findAll() {
        List<Seller> sellers = sellerDAO.findAll();
        sellers.forEach(seller -> {
            System.out.println(seller.toString());
        });
    }
}
