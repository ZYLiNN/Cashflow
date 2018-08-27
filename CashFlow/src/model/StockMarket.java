package model;

import exception.DepositNotEnoughException;
import exception.PlayerStocksAmountNotEnoughException;
import exception.PlayerStocksNotExistException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class StockMarket implements Serializable {
    private Scanner input = new Scanner(System.in);
    private static HashMap<Integer, Stock> stockHashMap = new HashMap<>();

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

    public static HashMap<Integer, Stock> getStockHashMap() {
        return stockHashMap;
    }

    public void setStockHashMap(HashMap<Integer, Stock> stockHashMap) {
        StockMarket.stockHashMap = stockHashMap;
    }

    public void showInfo() {
        for (int i = 1; i <= stockHashMap.size(); i++) {
            Stock stock = stockHashMap.get(i);
            System.out.println("(" + stock.getId() + ") " + stock.getName() + " " + stock.getPrice());
        }
    }

    public void tradeStocks(Player player) throws DepositNotEnoughException, PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException {
        int choice = player.makeChoice();
        player.showPlayerOwnStocks();
        switch (choice) {
            case 1:
                playerBuyStock(player);
                break;
            case 2:
                playerSoldStock(player);
                break;
            default:
                break;

        }
    }

    //Todo 優化
    private void playerSoldStock(Player player) throws PlayerStocksAmountNotEnoughException, PlayerStocksNotExistException {
        Stock stock = stockHashMap.get(player.chooseStock());
        int amount = player.determineStockAmount();
        player.soldStocks(stock, amount);
    }

    private void playerBuyStock(Player player) throws DepositNotEnoughException {
        Stock stock = stockHashMap.get(player.chooseStock());
        int amount = player.determineStockAmount();
        player.buyStocks(stock, amount);
    }

    public void stocksInfoChange() {
        for(int i = 1; i <= stockHashMap.size(); i++){
            int num = (int)(Math.random() * 3);
            int money = (int) (Math.random() * 400) + 100;
            Stock stock = stockHashMap.get(i);
            int  stockPrice = stock.getPrice();
            switch (num) {
                case 1:
                    stock.setPrice(stockPrice + money);
                    stockHashMap.put(i, stock);
                    break;
                case 2:
                    stock.setPrice(stockPrice - money < 0 ? 100 : stockPrice - money);
                    stockHashMap.put(i, stock);
                default:
                    break;
            }
        }
    }
}
