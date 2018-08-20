package game;

import game.CashFlow;
import model.StocksRepositoryImp;
import model.StockMarket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean playAgain;

        do {
            System.out.println("1.開始新遊戲 2.繼續遊戲");
            int choice = input.nextInt();
            if (choice == 1) {
                CashFlow cashFlow = new CashFlow(new StockMarket(new StocksRepositoryImp()));
                cashFlow.configureGame();
                cashFlow.startGame();
            }
            else{

            }
            System.out.println("再玩一次?(y/n): ");
            playAgain = input.next().equals("y");
        } while (playAgain);

    }

}