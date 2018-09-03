package model;

import exception.DepositNotEnoughException;
import exception.PlayerStocksAmountNotEnoughException;
import exception.PlayerStocksNotExistException;

import java.io.Serializable;
import java.util.HashMap;

public class StockMarket implements Serializable {
    private HashMap<Integer, Stock> stockHashMap = new HashMap<>();
    private final int INCREASE = 1;
    private final int DECREASE = 2;

    public StockMarket() {
        createStocks();
    }

    private void createStocks() {
        stockHashMap.put(1, new Stock(1, "鴻海", 1000));
        stockHashMap.put(2, new Stock(2, "宏達電", 1000));
        stockHashMap.put(3, new Stock(3, "蘋果", 1000));
        stockHashMap.put(4, new Stock(4, "台積電", 1000));
        stockHashMap.put(5, new Stock(5, "富士康", 1000));
    }

    public HashMap<Integer, Stock> getStockHashMap() {
        return stockHashMap;
    }

    public void setStockHashMap(HashMap<Integer, Stock> stockHashMap) {
        this.stockHashMap = stockHashMap;
    }

    public void showInfo() {
        for (int i = 1; i <= stockHashMap.size(); i++) {
            Stock stock = stockHashMap.get(i);
            System.out.println(stock);
        }
    }

    public void tradeStocks(Player player, int choice, int stockId, int amount) throws DepositNotEnoughException, PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException {
        switch (choice) {
            case 1:
                playerBuyStock(player, stockId, amount);
                break;
            case 2:
                playerSoldStock(player, stockId, amount);
                break;
        }
    }

    private void playerSoldStock(Player player, int stockId, int amount) throws PlayerStocksAmountNotEnoughException, PlayerStocksNotExistException {
        Stock stock = stockHashMap.get(stockId);
        if (player.getPlayerStockHashMap().get(stockId) == null)
            throw new PlayerStocksNotExistException();
        else if (player.getPlayerStockHashMap().get(stockId).getAmount() < amount)
            throw new PlayerStocksAmountNotEnoughException();
        else {
            player.deposit += (stock.getPrice() * amount);
            amount = player.getPlayerStockHashMap().get(stockId).getAmount() - amount;
            if(amount == 0)
                player.playerStockHashMap.remove(stockId);
            else
                player.playerStockHashMap.put(stockId, new PlayerStock(stock, amount));
        }
    }

    private void playerBuyStock(Player player, int stockId, int amount) throws DepositNotEnoughException {
        Stock stock = stockHashMap.get(stockId);
        if (player.getDeposit() < (stock.getPrice() * amount))
            throw new DepositNotEnoughException();
        else {
            player.deposit -= (stock.getPrice() * amount);
            amount = player.playerStockHashMap.get(stock.getId()) != null ? player.playerStockHashMap.get(stock.getId()).getAmount() + amount : amount;
            player.playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
        }
    }

    public void changeStocksInfo() {
        int ran = (int) (Math.random() * 19) + 1;
        for (int i = 1; i <= stockHashMap.size(); i++) {
            int finalPrice = 0;
            int money;
            Stock stock = stockHashMap.get(i);
            switch (ran % i) {
                case 0:
                    finalPrice = (int) (Math.random() * 150) + 1;
                    break;
                case 1:
                    finalPrice = (int) (Math.random() * 297) + 1;
                    break;
                case 2:
                    money = (int) (Math.random() * 134) + 1;
                    finalPrice = ((int) (Math.random() * 3) + 1) * money;
                    break;
                case 3:
                    money = (int) (Math.random() * 242) + 1;
                    finalPrice = ((int) (Math.random() * 5) + 1) * money;
                    break;
                case 4:
                    money = (int) (Math.random() * 792) + 1;
                    finalPrice = ((int) (Math.random() * 3) + 1) * money;
                    break;
            }
            increaseOrDecreaseStocks(stock, finalPrice);
        }
    }

    public void increaseOrDecreaseStocks(Stock stock, int price) {
        int ran = (int) (Math.random() * 3);
        int stockPrice = stock.getPrice();
        switch (ran) {
            case INCREASE:
                stock.setPrice(stockPrice + price);
                break;
            case DECREASE:
                stock.setPrice(stockPrice - price < 0 ? 100 : stockPrice - price);
                break;
        }
    }

}
