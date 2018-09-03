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
    protected  transient Scanner input = new Scanner(System.in);

    protected HashMap<Integer, PlayerStock> playerStockHashMap = new HashMap<>();

    public Player(int id) {
        this.id = id;
        deposit = 6000;
        this.createName();
    }

    public abstract void createName();

    public abstract int makeChoice();

    public abstract void buyOrSoldStocks();

//    //Todo
//    public void buyStocks(Stock stock, int amount) throws DepositNotEnoughException{
//        if (deposit < (stock.getPrice() * amount))
//            throw new DepositNotEnoughException();
//        else {
//            deposit -= (stock.getPrice() * amount);
//            amount = playerStockHashMap.get(stock.getId()) != null ? playerStockHashMap.get(stock.getId()).getAmount() + amount : amount;
//            playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
//        }
//    }
//
//    //Todo
//    public void soldStocks(Stock stock, int amount) throws PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException{
//        if (playerStockHashMap.get(stock.getId()) == null)
//            throw new PlayerStocksNotExistException();
//        else if (playerStockHashMap.get(stock.getId()).getAmount() < amount)
//            throw new PlayerStocksAmountNotEnoughException();
//        else {
//            deposit += (stock.getPrice() * amount);
//            amount = playerStockHashMap.get(stock.getId()).getAmount() - amount;
//            if(amount == 0)
//                playerStockHashMap.remove(stock.getId());
//            else
//                playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
//        }
//    }

    //todo map size
    public void showPlayerOwnStocks(int size) {
        System.out.println("--擁有");
        if(playerStockHashMap != null){
            for (int s = 0; s < size; s++){
                PlayerStock playerStock = playerStockHashMap.get(s+1);
                if(playerStock != null)
                    System.out.println(playerStock);
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

    public void setInput(Scanner input) {
        this.input = input;
    }

}
