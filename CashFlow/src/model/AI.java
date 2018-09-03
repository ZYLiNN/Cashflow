package model;


import java.util.HashMap;

public class AI extends Player {
    private StockMarket stockMarket;
    private HashMap<Integer, Integer> stockCompareHashMap = new HashMap<>();
    private int soldOrBuy;
    private int theBestStock = 1;
    private final int BUY = 1;
    private final int SOLD = 2;
    private final int EXIT = 0;

    public AI(int id, StockMarket stockMarket) {
        super(id);
        this.stockMarket = stockMarket;
        setupStockCompareHashMap();
    }

    private void setupStockCompareHashMap() {
        for (int i = 1; i <= stockMarket.getStockHashMap().size(); i++) {
            Stock stock = stockMarket.getStockHashMap().get(i);
            stockCompareHashMap.put(stock.getId(), stock.getPrice());
        }
    }

    @Override
    public void createName() {
        String[] aiNames = {"Min", "Pan", "Ana", "Woo", "Liu", "Ning"};
        this.name = aiNames[(int) (Math.random() * (aiNames.length))];
    }

    @Override
    public int makeChoice() {
        refreshStockCompareHashMap();
        System.out.println(stockCompareHashMap.get(1));
        if (playerStockHashMap.size() == 0) {
            soldOrBuy = BUY;
            return BUY;
        } else if (shouldAiChooseBuy())
            return BUY;
        else if (shouldAiChooseSold())
            return SOLD;
        return EXIT;
    }

    private void refreshStockCompareHashMap() {
        for (int i = 1; i <= stockCompareHashMap.size(); i++) {
            Stock stock = stockMarket.getStockHashMap().get(i);
            stockCompareHashMap.replace(stock.getId(), stock.getPrice());
        }setupStockCompareHashMap();
    }

    private boolean shouldAiChooseSold() {
        for (int s = 1; s <= stockMarket.getStockHashMap().size(); s++) {
            if (stockMarket.getStockHashMap().get(s).getPrice() >= 1340) {
                soldOrBuy = SOLD;
                return true;
            } else if (stockMarket.getStockHashMap().get(s).getPrice() - stockCompareHashMap.get(s) >= 350) {
                soldOrBuy = SOLD;
                return true;
            }
        }
        return false;
    }

    private boolean shouldAiChooseBuy() {
        for (int s = 1; s <= stockMarket.getStockHashMap().size(); s++) {
            if (stockMarket.getStockHashMap().get(s).getPrice() <= 800) {
                soldOrBuy = BUY;
                return true;
            } else if (stockCompareHashMap.get(s) - stockMarket.getStockHashMap().get(s).getPrice() >= 300) {
                soldOrBuy = BUY;
                return true;
            }
        }
        return false;
    }

    @Override
    public int chooseStock() {
        int bestSoldBenefit = 0;
        int bestBuyBenefit = 20000;
        if (soldOrBuy == SOLD) {
            for (int i = 0; i < stockMarket.getStockHashMap().size(); i++) {
                if (playerStockHashMap.get(i) != null) {
                    PlayerStock playerStock = playerStockHashMap.get(i);
                    if (playerStock.getStock().getPrice() > stockCompareHashMap.get(i)) {
                        int benefit = playerStock.getStock().getPrice() - stockCompareHashMap.get(i);
                        if (benefit > bestSoldBenefit) {
                            bestSoldBenefit = benefit;
                            theBestStock = i;
                        }
                    }
                }
            }
        } else {
            for (int j = 1; j <= stockMarket.getStockHashMap().size(); j++) {
                int benefit = stockMarket.getStockHashMap().get(j).getPrice();
                if (benefit < bestBuyBenefit) {
                    bestBuyBenefit = benefit;
                    theBestStock = j;
                }
            }
        }
        return theBestStock;
    }

    @Override
    public int determineStockAmount() {
        int amount = 0;
        int bestSoldBenefit = 0;
        int bestBuyBenefit = 20000;
        if (soldOrBuy == BUY) {
            if (stockMarket.getStockHashMap().get(theBestStock).getPrice() < 700) {
                amount = deposit / stockMarket.getStockHashMap().get(theBestStock).getPrice();
                int num = amount / 2;
                amount += num;
            } else
                amount = deposit / stockMarket.getStockHashMap().get(theBestStock).getPrice();
        } else {
            if (stockMarket.getStockHashMap().get(theBestStock).getPrice() > 1400)
                amount = playerStockHashMap.get(theBestStock).getAmount();
            else if (stockMarket.getStockHashMap().get(theBestStock).getPrice() > 1200) {
                amount = playerStockHashMap.get(theBestStock).getAmount() / 2;
                int num = amount / 2;
                amount += num;
            } else {
                amount = playerStockHashMap.get(theBestStock).getAmount() / 2;
            }
        }
        return amount;
    }


//    @Override
//    public void buyStocks(Stock stock, int amount) throws DepositNotEnoughException {
//        if (deposit < (stock.getPrice() * amount))
//            throw new DepositNotEnoughException();
//        else {
//            deposit -= (stock.getPrice() * amount);
//            amount = playerStockHashMap.get(stock.getId()) != null ? playerStockHashMap.get(stock.getId()).getAmount() + amount : amount;
//            playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
//        }
//    }
//
//    @Override
//    public void soldStocks(Stock stock, int amount) throws PlayerStocksNotExistException, PlayerStocksAmountNotEnoughException {
//        if (playerStockHashMap.get(stock.getId()) == null)
//            throw new PlayerStocksNotExistException();
//        else if (playerStockHashMap.get(stock.getId()).getAmount() < amount)
//            throw new PlayerStocksAmountNotEnoughException();
//        else {
//            deposit += (stock.getPrice() * amount);
//            amount = playerStockHashMap.get(stock.getId()).getAmount() - amount;
//            //如果小於0，從MAP中刪掉
//            if(amount == 0)
//                playerStockHashMap.remove(stock.getId());
//            else
//                playerStockHashMap.put(stock.getId(), new PlayerStock(stock, amount));
//        }
//    }

}
