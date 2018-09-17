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
    private GameSaveManager gameWriterAndReader = new GameSaveManager();
    private final int REALPLAYER = 1;
    private final int EXIT = 0;

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
            players.add(category == REALPLAYER ? new RealPlayer(i) : new AI(i, stockMarket));
        }
    }

    public void startGame() {
        while (!isGameOver) {
            stockMarket.showInfo();
            currentPlayer.showPlayerOwnStocks(stockMarket.getStockHashMap().size());
            try {
                tradStock();
            } catch (DepositNotEnoughException | PlayerStocksNotExistException | PlayerStocksAmountNotEnoughException err) {
                err.printStackTrace();
            }
            judgeAnyPlayerWinTheGameAndSetupWinner(currentPlayer);
            turnToNextPlayer();
            if(playerIndex % 4 == 0)
                stockMarket.changeStocksInfo();
            recordGame();
        }
        System.out.println("Winner is: " + winner.getName());
    }

    private void tradStock() throws PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException, DepositNotEnoughException {
        int choice = currentPlayer.makeChoice();
        if (choice == EXIT)
            System.out.println();
        else {
            int stockId = currentPlayer.chooseStock();
            int amount = currentPlayer.determineStockAmount();
            stockMarket.tradeStocks(currentPlayer, choice, stockId, amount);
        }
    }

    private void judgeAnyPlayerWinTheGameAndSetupWinner(Player currentPlayer) {
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
        gameWriterAndReader.writeGameRecord(stockMarket, players, currentPlayer, playerIndex);
    }

    public void readGameRecord(){
        gameWriterAndReader.readGameRecord();
        this.stockMarket = gameWriterAndReader.getStockMarket();
        this.players = gameWriterAndReader.getPlayers();
        this.currentPlayer = gameWriterAndReader.getCurrentPlayer();
        this.playerIndex = gameWriterAndReader.getPlayerIndex();
        for(Player player : players)
            player.setInput(input);
    }

}
