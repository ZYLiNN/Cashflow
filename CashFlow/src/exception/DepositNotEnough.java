package exception;

public class DepositNotEnough extends Exception{
    @Override
    public String getMessage() {
        return "餘額不足，請重新操作";
    }
}
