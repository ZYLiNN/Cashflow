package model;


public class AI extends Player {
    public AI(int id, String name) {
        super(id, name);
    }

    @Override
    public int makeChoice() {
        return (int)(Math.random() * 3);
    }

    @Override
    public int chooseStock() {
        return (int)(Math.random() * StockMarket.getStockHashMap().size()) + 1;
    }

    @Override
    public int determineStockAmount() {
        return (int)(Math.random() * 3) + 1;
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
