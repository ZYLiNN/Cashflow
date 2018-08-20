package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public abstract class Market implements Serializable {
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
