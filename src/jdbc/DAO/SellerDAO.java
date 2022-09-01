package jdbc.DAO;

import jdbc.DB;
import jdbc.Queries;
import jdbc.entities.Seller;
import jdbc.exceptions.DbException;

import java.sql.*;

public class SellerDAO {

    public int insertSeller(Seller seller) {
        try {
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(Queries.INSERT_SELLER, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, seller.getName());
            ps.setString(2, seller.getEmail());
            ps.setDate(3, seller.getBirthDate());
            ps.setDouble(4, seller.getBaseSalary());
            ps.setInt(5, seller.getDepartmentId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet resultSet = ps.getGeneratedKeys();
                int FIRST_COLUMN = 1;
                while (resultSet.next()) {
                    int generatedId = resultSet.getInt(FIRST_COLUMN);
                    System.out.println("created, ID:" + generatedId);
                }
            }
            return rowsAffected;
        }
        catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeConnection();
        }
    }

    public void updateSellerSalary(int sellerId, Double newBaseSalary) {
        try {
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(Queries.UPDATE_SELLER_SALARY, Statement.NO_GENERATED_KEYS);
            ps.setDouble(1, newBaseSalary);
            ps.setInt(2, sellerId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Updated. Rows Affected: " + rowsAffected);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}
