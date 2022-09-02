package jdbc.DAO;

import jdbc.DB;
import jdbc.Queries;
import jdbc.entities.Seller;
import jdbc.exceptions.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void deleteSeller(int sellerId) {
        Connection conn = DB.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(Queries.DELETE_SELLER, Statement.NO_GENERATED_KEYS);
            ps.setInt(1, sellerId);

            int rowsAffected = ps.executeUpdate();
            conn.commit();
            if (rowsAffected > 0) {
                System.out.println("Deleted. Rows affected: " + rowsAffected);
            }
        }
        catch(SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back. error: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error while trying to rollback. error: " + e.getMessage());
            }
        }
    }

    public Seller findById(int id) {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(Queries.FIND_BY_ID, Statement.NO_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return instantiateSeller(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public List<Seller> findAll() {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(Queries.FIND_ALL, Statement.NO_GENERATED_KEYS);
            List<Seller> sellers = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sellers.add(instantiateSeller(rs));
            }
            return sellers;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
    private Seller instantiateSeller(ResultSet rs) {
        try {
            Seller seller = new Seller();
            seller.setId(rs.getInt("Id"));
            seller.setName(rs.getString("Name"));
            seller.setEmail(rs.getString("Email"));
            seller.setBirthDate(rs.getDate("BirthDate"));
            seller.setBaseSalary(rs.getDouble("BaseSalary"));
            seller.setDepartmentId(rs.getInt("DepartmentId"));
            return seller;
        }
        catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
