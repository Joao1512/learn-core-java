package jdbc;

import jdbc.DAO.DepartmentDAO;
import jdbc.exceptions.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

public class main {

    public static void main(String[] args) {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        LinkedHashSet<String> results = departmentDAO.listDepartments();
        results.forEach(item -> {
            System.out.println(item);
        });

    }


}
