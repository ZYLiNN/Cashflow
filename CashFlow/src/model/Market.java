package model;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Market implements Serializable {
    //Todo
    private StocksRepository stocksRepository;
    private HashMap<Integer, Stock> stocks;

    Market(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
        stocks = stocksRepository.createCompanies();
    }

    public abstract void showInfo();

    public HashMap<Integer, Stock> getStocks() {
        return stocks;
    }

    public void setStocks(HashMap<Integer, Stock> stocks) {
        this.stocks = stocks;
    }
}
