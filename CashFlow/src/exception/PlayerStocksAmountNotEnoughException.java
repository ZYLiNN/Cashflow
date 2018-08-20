package exception;

public class PlayerStocksAmountNotEnoughException extends Exception{
    @Override
    public String getMessage() {
        return "此玩家股票張數不足";
    }
}
