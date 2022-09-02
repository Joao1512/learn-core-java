package jdbc.exceptions;

public class DbIntegrityExeption extends RuntimeException{

    public DbIntegrityExeption(String msg) {
        super(msg);
    }
}
