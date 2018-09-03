package exception;

public class PlayerStocksNotExistException extends RuntimeException {
    @Override
    public String getMessage() {
        return "此玩家沒有該股票";
    }
}
