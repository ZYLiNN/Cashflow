import exception.DepositNotEnough;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashFlow {
    Scanner input = new Scanner(System.in);

    private List<Player> players = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    private boolean isGameOver;
    private int playerIndex = 0;
    private Player currentPlayer;
    private Market stockMarket;
    private String[] AI_names = {"Min", "Pan", "Ana", "Woo", "Liu"};

    public CashFlow(Market stockMarket) {
        this.stockMarket = stockMarket;
        isGameOver = false;
    }

    void configureGame() {
        companies = stockMarket.getCompanies();
        createPlayers();
    }

    private void createPlayers() {
        for (int i = 1; i < 5; i++) {
            System.out.println("請輸入玩家" + i + "類型(1.真人 2.AI): ");
            int category = input.nextInt();
            String name = category == 1 ? input.next() : AI_names[(int) (Math.random()) * 4];
            players.add(category == 1 ? new RealPlayer(i, name) : new AI(i, name));
        }
    }

    void startGame() {
        currentPlayer = players.get(0);
        while (!isGameOver) {
            stockMarket.showInfo();
            playerOperate(currentPlayer);
            turnToNextPlayer();
        }
    }

    private void playerOperate(Player player) {
        System.out.println("1.買進 2.賣出 0.結束");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("請輸入欲購買支股票ID:");
                int companyId = input.nextInt();
                System.out.println("請輸入買進數量: ");
                int num = input.nextInt();
                if (player.getDeposit() < (companies.get(companyId - 1).getStockPrice() * num))
                    try {
                        throw new DepositNotEnough();
                    } catch (DepositNotEnough err) {
                        err.printStackTrace();
                    }
//                else


        }
    }

    private void turnToNextPlayer() {
        playerIndex++;
        currentPlayer = players.get(playerIndex % 4);
        System.out.println("輪到玩家" + currentPlayer.getName() + "操作");
    }
}
