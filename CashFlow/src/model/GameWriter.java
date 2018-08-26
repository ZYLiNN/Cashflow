package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class GameWriter {
    public void writeGameRecorde(StockMarket stockMarket, List<Player> players){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Lin\\IdeaProjects\\CashFlow\\GameRecorde");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stockMarket);
            objectOutputStream.writeObject(players);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
