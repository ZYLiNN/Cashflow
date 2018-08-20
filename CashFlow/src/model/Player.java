package model;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Player implements Serializable {
    private int id;
    private String name;
    private int deposit;
    private HashMap<Integer, Stock> playerStockHashMap = new HashMap<>();
    private HashMap<Integer, Integer> playerStockAmountHashMap = new HashMap<>();

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        deposit = 6000;
    }

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

    public HashMap<Integer, Stock> getPlayerStockHashMap() {
        return playerStockHashMap;
    }

    public void setPlayerStockHashMap(HashMap<Integer, Stock> playerStockHashMap) {
        this.playerStockHashMap = playerStockHashMap;
    }

    public HashMap<Integer, Integer> getPlayerStockAmountHashMap() {
        return playerStockAmountHashMap;
    }

    public void setPlayerStockAmountHashMap(HashMap<Integer, Integer> playerStockAmountHashMap) {
        this.playerStockAmountHashMap = playerStockAmountHashMap;
    }

    public void addPlayerDeposit(int money){
        deposit += money;
    }

    public void subPlayerDeposit(int money){
        deposit -= money;
    }

    public void addPlayerStock(Stock stock, int amount){
        playerStockHashMap.put(stock.getId(), stock);
        playerStockAmountHashMap.put(stock.getId(), amount);
    }

    public void subPlayerStock(Stock stock, int amount){

    }

}
