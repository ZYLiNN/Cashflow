package model;

public class Player {
    private int id;
    private String name;
    private int deposit;
    private StockOfPlayer stockOfPlayer;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        deposit = 6000;
        stockOfPlayer = null;
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

    public StockOfPlayer getStockOfPlayer() {
        return stockOfPlayer;
    }

    public void setStockOfPlayer(StockOfPlayer stockOfPlayer) {
        this.stockOfPlayer = stockOfPlayer;
    }
}
