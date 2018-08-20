package model;

import java.util.HashMap;

public class StockMarket extends Market{
    private HashMap<Integer, Stock> marketStocks;

    public StockMarket(StocksRepository stocksRepository) {
        super(stocksRepository);
        marketStocks = stocksRepository.createCompanies();
    }

    @Override
    public void showInfo() {
        showStocksInfo();
    }

    void showStocksInfo(){
        for (int i = 0; i < marketStocks.size(); i++){
            Stock stock = marketStocks.get(i+1);
            System.out.println("(" + stock.getId() + ") " + stock.getName() + " " + stock.getPrice() + "$ ");
        }
    }

}
