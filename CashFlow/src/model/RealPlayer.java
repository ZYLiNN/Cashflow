package model;

import exception.DepositNotEnoughException;
import exception.PlayerStocksAmountNotEnoughException;

public class RealPlayer extends Player {
    public RealPlayer(int id, String name) {
        super(id, name);
    }

    @Override
    public void buyOrSoldStocks() {
        System.out.println("玩家: " + name);
        System.out.println("手頭現金: " + deposit);
        System.out.println("1.買進 2.賣出 0.結束");
        int choice = input.nextInt();
        showPlayerOwnStocks();
        switch (choice) {
            case 1:
//                System.out.println("請輸入欲購買之股票ID:");
//                int stockId = input.nextInt();
//                System.out.println("請輸入買進數量: ");
//                int amount = input.nextInt();
//                Stock stock = stockHashMap.get(stockId);
//                if (player.getDeposit() < (stock.getPrice() * amount))
//                    try {
//                        throw new DepositNotEnoughException();
//                    } catch (DepositNotEnoughException err) {
//                        err.printStackTrace();
//                    }
//                else {
//                    player.buyStocks(stock, amount);
//                }
                break;
            case 2:
//                System.out.println("請輸入欲販賣之股票編號: ");
//                stockId = input.nextInt();
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


}
