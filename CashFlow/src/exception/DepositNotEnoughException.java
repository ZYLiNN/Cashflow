package exception;

public class DepositNotEnoughException extends Exception{
    @Override
    public String getMessage() {
        return "餘額不足，請重新操作";
    }
}
