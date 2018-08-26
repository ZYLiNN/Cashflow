package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class StockMarket implements Serializable {
    //Todo
//    private HashMap<Integer, Stock> stocks;
    private List<Stock> stocks = new ArrayList<>();

    public StockMarket() {
        createStocks();
    }

    private void createStocks() {
//        stocks.put(1, new Stock(1, "鴻海", 6000));
//        stocks.put(2, new Stock(2, "宏達電", 6000));
//        stocks.put(3, new Stock(3, "蘋果", 6000));
//        stocks.put(4, new Stock(4, "台積電", 6000));
//        stocks.put(5, new Stock(5, "富士康", 6000));
        stocks.add(new Stock(1, "鴻海", 6000));
        stocks.add(new Stock(2, "宏達電", 6000));
        stocks.add(new Stock(3, "蘋果", 6000));
        stocks.add(new Stock(4, "台積電", 6000));
        stocks.add(new Stock(5, "富士康", 6000));
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    //    public HashMap<Integer, Stock> getStocks() {
//        return stocks;
//    }
//
//    public void setStocks(HashMap<Integer, Stock> stocks) {
//        this.stocks = stocks;
//    }

    public  void showInfo(){
        for(Stock stock : stocks)
            System.out.println("(" + stock.getId() + ") " + stock.getName() + " " + stock.getPrice());
    }

    public void tradeStocks(Player player){
        player.buyOrSoldStocks();
    }

    public void stocksInfoChange() {

    }
}
