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

//    public abstract void buyOrSoldStocks();

    public abstract int makeChoice();

    public abstract void buyStocks(Stock stock, int amount) throws DepositNotEnoughException;

    public abstract void soldStocks(Stock stock, int amount) throws PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException;

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
