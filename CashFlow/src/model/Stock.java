package model;

import java.io.Serializable;

public class Stock implements Serializable {
    private int id;
    private String name;
    private int price;

    public Stock(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void increaseOrDecreaseStockPrice(){
        int money = (int) (Math.random() * 500);
        int choice = (int) (Math.random() * 2);
        price = choice == 0 ? price + money : price - money;
        price = price < 0 ? 0 : price;
    }

}