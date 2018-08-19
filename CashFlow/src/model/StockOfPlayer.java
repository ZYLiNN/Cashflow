package model;

import java.util.ArrayList;
import java.util.List;

public class StockOfPlayer {
    private List<Company> stocksOfPlayer = new ArrayList<>();
    private List<Integer> stockAmount = new ArrayList<>();

    public List<Company> getStocksOfPlayer() {
        return stocksOfPlayer;
    }

    public void setStocksOfPlayer(List<Company> stocksOfPlayer) {
        this.stocksOfPlayer = stocksOfPlayer;
    }

    public List<Integer> getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(List<Integer> stockAmount) {
        this.stockAmount = stockAmount;
    }
}
