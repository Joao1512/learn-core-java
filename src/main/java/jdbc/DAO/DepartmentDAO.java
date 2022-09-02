package jdbc.DAO;

import jdbc.DB;
import jdbc.Queries;
import jdbc.exceptions.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

public class DepartmentDAO {

    public LinkedHashSet<String> listDepartments() {
        Connection conn = DB.getConnection();
        try {
            Statement statement =  conn.createStatement();
            ResultSet result = statement.executeQuery(Queries.LIST_DEPARTMENTS);
            LinkedHashSet<String> results = new LinkedHashSet<String>();
            while (result.next()) {
                results.add("Id: " + result.getInt("Id") + ", name: " + result.getString("Name"));
            }
            return results;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeConnection();
        }
    }
}
