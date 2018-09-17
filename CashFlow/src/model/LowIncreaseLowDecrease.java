package model;

public class LowIncreaseLowDecrease implements StockAlgorithm {

    @Override
    public int increasePrice() {
        return (int) (Math.random() * 500) + 1;
    }

    @Override
    public int decreasePrice() {
        return (int) (Math.random() * 400) + 1;
    }
}
