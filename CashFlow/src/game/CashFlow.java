package game;

import exception.DepositNotEnoughException;
import exception.PlayerStocksAmountNotEnoughException;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CashFlow {
    private Scanner input = new Scanner(System.in);

    private List<Player> players = new ArrayList<>();
    private HashMap<Integer, Stock> stockHashMap;
    private boolean isGameOver;
    private int playerIndex = 0;
    private Player currentPlayer;
    private StockMarket stockMarket;
    private GameWriter gameWriter = new GameWriter();
    private GameReader gameReader = new GameReader();
    private String[] AI_names = {"Min", "Pan", "Ana", "Woo", "Liu", "Ning"};

    public CashFlow(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
        isGameOver = false;
    }

    void configureGame() {
//        stockHashMap = stockMarket.getStocks();
        createPlayers();
    }

    private void createPlayers() {
        for (int i = 1; i < 5; i++) {
            System.out.println("請輸入玩家" + i + "類型(1.真人 2.AI): ");
            int category = input.nextInt();
            String name = category == 1 ? input.next() : AI_names[(int) (Math.random() * (AI_names.length))];
            players.add(category == 1 ? new RealPlayer(i, name) : new AI(i, name));
        }
    }

    void startGame() {
        currentPlayer = players.get(0);
        while (!isGameOver) {
            stockMarket.showInfo();
            stockMarket.tradeStocks(currentPlayer);
//            currentPlayer.buyOrSoldStocks();
            turnToNextPlayer();
            stockMarket.stocksInfoChange();
            recordGame();
        }
    }

    private void playerOperate(Player player) {
        System.out.println("玩家: " + player.getName());
        System.out.println("手頭現金: " + player.getDeposit());
        System.out.println("1.買進 2.賣出 0.結束");
        int choice = input.nextInt();
        player.showPlayerOwnStocks();
        switch (choice) {
            case 1:
                System.out.println("請輸入欲購買之股票ID:");
                int stockId = input.nextInt();
                System.out.println("請輸入買進數量: ");
                int amount = input.nextInt();
                Stock stock = stockHashMap.get(stockId);
                if (player.getDeposit() < (stock.getPrice() * amount))
                    try {
                        throw new DepositNotEnoughException();
                    } catch (DepositNotEnoughException err) {
                        err.printStackTrace();
                    }
                else {
//                    player.buyStocks(stock, amount);
                }
                break;
            case 2:
                System.out.println("請輸入欲販賣之股票編號: ");
                stockId = input.nextInt();
//                if (player.getPlayerStockAmountHashMap().get(stockId) == null){
//                    try {
//                        throw new PlayerStocksAmountNotEnoughException();
//                    } catch (PlayerStocksAmountNotEnoughException err) {
//                        err.printStackTrace();
//                    }
//                } else {
//
//                }
                break;
            default:
                break;

        }
    }

    private void turnToNextPlayer() {
        playerIndex++;
        currentPlayer = players.get(playerIndex % 4);
        System.out.println("輪到玩家" + currentPlayer.getName() + "操作");
    }

    public void recordGame(){

    }
}
