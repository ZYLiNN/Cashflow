package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class GameWriter {
    private final String FILENAME = "E:\\GitHub\\Cashflow\\GameRecord";

    public void writeGameRecord(StockMarket stockMarket, List<Player> players){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
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
