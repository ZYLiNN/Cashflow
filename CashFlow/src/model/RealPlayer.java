package model;

import java.util.Scanner;

public class RealPlayer extends Player {
    public RealPlayer(int id) {
        super(id);
    }

    @Override
    public void createName() {
        System.out.println("請輸入玩家姓名: ");
        this.name = input.next();
    }

    @Override
    public int makeChoice() {
        System.out.println("玩家: " + name);
        System.out.println("手頭現金: " + deposit);
        System.out.println("1.買進 2.賣出 0.結束");
        return input.nextInt();
    }

    @Override
    public void buyOrSoldStocks() {

    }

    @Override
    public int chooseStock() {
        System.out.println("請輸入股票之ID:");
        return input.nextInt();
    }

    @Override
    public int determineStockAmount() {
        System.out.println("請輸入數量: ");
        return input.nextInt();
    }

//    @Override
////    public void buyStocks(Stock stock, int amount) throws DepositNotEnoughException {
////        if (deposit < (stock.getPrice() * amount))
////            throw new DepositNotEnoughException();
////        else {
////            deposit -= (stock.getPrice() * amount);
////            amount = playerStockHashMap.get(stock.getId()) != null ? playerStockHashMap.get(stock.getId()).getAmount() + amount : amount;
////            playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
////        }
////    }
////
////    @Override
////    public void soldStocks(Stock stock, int amount) throws PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException {
////        if (playerStockHashMap.get(stock.getId()) == null)
////            throw new PlayerStocksNotExistException();
////        else if (playerStockHashMap.get(stock.getId()).getAmount() < amount)
////            throw new PlayerStocksAmountNotEnoughException();
////        else {
////            deposit += (stock.getPrice() * amount);
////            amount = playerStockHashMap.get(stock.getId()).getAmount() - amount;
////            if(amount == 0)
////                playerStockHashMap.remove(stock.getId());
////            else
////                playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
////        }
////    }

//    @Override
//    public void buyOrSoldStocks() {
//        System.out.println("玩家: " + name);
//        System.out.println("手頭現金: " + deposit);
//        System.out.println("1.買進 2.賣出 0.結束");
//        int choice = input.nextInt();
//        showPlayerOwnStocks();
//        switch (choice) {
//            case 1:
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
//                break;
//            case 2:
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
//                break;
//            default:
//                break;
//
//        }
//    }

}
