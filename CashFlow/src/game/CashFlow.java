package game;

import exception.DepositNotEnoughException;
import exception.PlayerStocksAmountNotEnoughException;
import exception.PlayerStocksNotExistException;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashFlow {
    private Scanner input = new Scanner(System.in);

    private List<Player> players = new ArrayList<>();
    private boolean isGameOver;
    private int playerIndex = 0;
    private Player currentPlayer;
    private Player winner = null;
    private StockMarket stockMarket;
    private GameWriter gameWriter = new GameWriter();
    private GameReader gameReader = new GameReader();
    private String[] aiNames = {"Min", "Pan", "Ana", "Woo", "Liu", "Ning"};

    public CashFlow() {
        stockMarket = new StockMarket();
        isGameOver = false;
    }

    public void initGame() {
        createPlayers();
        currentPlayer = players.get(0);
    }

    private void createPlayers() {
        for (int i = 1; i < 5; i++) {
            System.out.println("請輸入玩家" + i + "類型(1.真人 2.AI): ");
            int category = input.nextInt();
            if(category == 1)
                System.out.println("請輸入玩家姓名: ");
            String name = category == 1 ? input.next() : aiNames[(int) (Math.random() * (aiNames.length))];
            players.add(category == 1 ? new RealPlayer(i, name) : new AI(i, name));
        }
    }

    public void startGame() {
        while (!isGameOver) {
            stockMarket.showInfo();
            try {
                stockMarket.tradeStocks(currentPlayer);
            } catch (DepositNotEnoughException | PlayerStocksNotExistException | PlayerStocksAmountNotEnoughException err) {
                err.printStackTrace();
            }
            isPlayerWinTheGame(currentPlayer);
            turnToNextPlayer();
            stockMarket.stocksInfoChange();
            recordGame();
        }
        System.out.println("Winner is: " + winner.getName());
    }


    //Todo
    private void isPlayerWinTheGame(Player currentPlayer) {
        if(currentPlayer.getDeposit() >= 10000) {
            isGameOver = currentPlayer.getDeposit() >= 10000;
            winner = currentPlayer;
        }
    }

    private void turnToNextPlayer() {
        playerIndex++;
        currentPlayer = players.get(playerIndex % 4);
        System.out.println("輪到玩家" + currentPlayer.getName() + "操作");
    }

    private void recordGame(){
        gameWriter.writeGameRecord(stockMarket, players);
    }

    public void readGameRecord(){
        gameReader.readGameRecord();
        this.stockMarket = gameReader.getStockMarket();
        this.players = gameReader.getPlayers();
    }

}
