import exception.DepositNotEnough;
import model.Company;
import model.Market;
import model.Player;

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

    public CashFlow(Market stockMarket) {
        this.stockMarket = stockMarket;
        isGameOver = false;
    }

    void configureGame() {
        companies = stockMarket.getCompanies();
        createPlayers();
    }

    private void createPlayers() {
        for (int i = 0; i < 4; i++) {
            System.out.println("請輸入玩家" + (i + 1) + "姓名: ");
            String name = input.next();
            players.add(new Player(i, name));
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
