package courses.exc;

public class ApiException extends RuntimeException {
    private final int _status;

    public ApiException(int status, String message){
        super(message);
        this._status = status;
    }

    public int getStatus(){
        return _status;
    }
}
