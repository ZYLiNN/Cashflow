package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class GameReader {
    private StockMarket stockMarket = null;
    private List<Player> players = null;

    public void readGameRecorde(){
        try {

            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Lin\\IdeaProjects\\CashFlow\\GameRecorde");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            stockMarket = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
