package model;

import java.io.*;
import java.util.List;

public class GameWriterAndReader {
    private static final String FILENAME = "record";
    private StockMarket stockMarket = null;
    private List<Player> players = null;
    private Player currentPlayer = null;
    private int playerIndex;

    //todo
    public void writeGameRecord(StockMarket stockMarket, List<Player> players, Player currentPlayer, int playerIndex){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stockMarket);
            objectOutputStream.writeObject(players);
            objectOutputStream.writeObject(currentPlayer);
            objectOutputStream.writeObject(playerIndex);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void readGameRecord(){
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            stockMarket = (StockMarket) objectInputStream.readObject();
            players = (List<Player>) objectInputStream.readObject();
            currentPlayer = (Player) objectInputStream.readObject();
            playerIndex = (Integer) objectInputStream.readObject();
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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

}
