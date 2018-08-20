package exception;

public class PlayerStocksNotExistException extends Exception {
    @Override
    public String getMessage() {
        return "此玩家沒有該股票";
    }
}
