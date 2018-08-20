package model;

import java.util.HashMap;

public class StocksRepositoryImp implements StocksRepository {
    private HashMap<Integer, Stock> marketStocks = new HashMap();

    public StocksRepositoryImp() {
    }

    @Override
    public HashMap<Integer, Stock> createCompanies() {
        marketStocks.put(1, new Stock(1, "紅海", 1000));
        marketStocks.put(2, new Stock(2, "台積店", 1000));
        marketStocks.put(3, new Stock(3, "藤訊", 1000));
        marketStocks.put(4, new Stock(4, "宏達墊", 1000));
        marketStocks.put(5, new Stock(5, "頻果", 1000));
        return marketStocks;
    }

}
