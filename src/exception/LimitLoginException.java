package exception;

public class LimitLoginException extends Exception{
    public LimitLoginException() {
        super("Excedido limite de intentos");
    }
}
