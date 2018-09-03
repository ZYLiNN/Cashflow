package model;

import java.io.Serializable;

public class PlayerStock implements Serializable {
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

    @Override
    public String toString() {
        return "(" + stock.getId() + ") " + stock.getName() + " " + stock.getPrice() + "元 " + amount + "張";
    }
}
