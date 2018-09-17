package model;

import java.io.Serializable;

public class Stock implements Serializable {
    private final int INCREASE = 1;
    private final int DECREASE = 2;
    private int id;
    private String name;
    private int price;
    private StockAlgorithm stockAlgorithm;

    public Stock(int id, String name, int price, StockAlgorithm stockAlgorithm) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockAlgorithm = stockAlgorithm;
    }

    public void changePrice() {
        int ran = (int) (Math.random() * 3);
        switch (ran) {
            case INCREASE:
                price += stockAlgorithm.increasePrice();
                break;
            case DECREASE:
                price -= stockAlgorithm.decreasePrice();
                break;
        }
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + name + " " + price;
    }
}
