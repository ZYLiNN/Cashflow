package model;

import exception.DepositNotEnoughException;
import exception.PlayerStocksAmountNotEnoughException;
import exception.PlayerStocksNotExistException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Player implements Serializable {
    protected int id;
    protected String name;
    protected int deposit;
    protected HashMap<Integer, PlayerStock> playerStockHashMap = new HashMap<>();

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        deposit = 6000;
    }

    public abstract int makeChoice();

    //Todo
    public void buyStocks(Stock stock, int amount) throws DepositNotEnoughException{
        if (deposit < (stock.getPrice() * amount))
            throw new DepositNotEnoughException();
        else {
            deposit -= (stock.getPrice() * amount);
            amount = playerStockHashMap.get(stock.getId()) != null ? playerStockHashMap.get(stock.getId()).getAmount() + amount : amount;
            playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
        }
    }

    //Todo
    public void soldStocks(Stock stock, int amount) throws PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException{
        if (playerStockHashMap.get(stock.getId()) == null)
            throw new PlayerStocksNotExistException();
        else if (playerStockHashMap.get(stock.getId()).getAmount() < amount)
            throw new PlayerStocksAmountNotEnoughException();
        else {
            deposit += (stock.getPrice() * amount);
            amount = playerStockHashMap.get(stock.getId()).getAmount() - amount;
            if(amount == 0)
                playerStockHashMap.remove(stock.getId());
            else
                playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
        }
    }

    public void showPlayerOwnStocks() {
        System.out.println("--擁有");
        if(playerStockHashMap != null){
            for (int s = 0; s < StockMarket.getStockHashMap().size(); s++){
                PlayerStock playerStock = playerStockHashMap.get(s+1);
                if(playerStock != null)
                    System.out.println("(" + playerStock.stock.getId() + ") " + playerStock.stock.getName() + " " + playerStock.amount + "張");
            }
        }
    }

    public abstract int chooseStock();

    public abstract int determineStockAmount();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public HashMap<Integer, PlayerStock> getPlayerStockHashMap() {
        return playerStockHashMap;
    }

    public void setPlayerStockHashMap(HashMap<Integer, PlayerStock> playerStockHashMap) {
        this.playerStockHashMap = playerStockHashMap;
    }

    protected class PlayerStock{
        private Stock stock;
        private int amount;

        public PlayerStock(Stock stock, int amount) {
            this.stock = stock;
            this.amount = amount;
        }

        public Stock getStock() {
            return stock;
        }

        public void setStock(Stock stock) {
            this.stock = stock;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}
