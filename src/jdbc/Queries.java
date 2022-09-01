package jdbc;

public class Queries {

    public static final String LIST_DEPARTMENTS = "select * from department";
    public static final String INSERT_SELLER = "INSERT INTO seller " +
            "(Name, " +
            "Email, " +
            "BirthDate, " +
            "BaseSalary, " +
            "DepartmentId)" +
            "VALUES (" +
            "?, ?, ?, ?, ?" +
            ")";

    public static final String UPDATE_SELLER_SALARY = "UPDATE seller" +
            " SET baseSalary = ?" +
            " WHERE (" +
            "Id = ?" +
            ")";

    public static final String DELETE_SELLER = "DELETE from seller " +
            "WHERE (" +
            "Id = ?" +
            ")";
}
