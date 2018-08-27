package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class GameReader {
    private static final String FILENAME = "E:\\GitHub\\Cashflow\\GameRecord\\record.txt";
    private StockMarket stockMarket = null;
    private List<Player> players = null;

    //todo
    public void readGameRecord(){
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            stockMarket = (StockMarket) objectInputStream.readObject();
            players = (List<Player>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
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
