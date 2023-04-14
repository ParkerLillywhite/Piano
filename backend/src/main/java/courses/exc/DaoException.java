package src.main.java.courses.exc;

public class DaoException extends Exception {

    private final Exception originalException;
    public DaoException(Exception originalException, String errorMessage){
        super(errorMessage);
        this.originalException = originalException;
    }
}
