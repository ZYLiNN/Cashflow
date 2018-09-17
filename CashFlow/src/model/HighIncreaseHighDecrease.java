package model;

public class HighIncreaseHighDecrease implements StockAlgorithm {

    @Override
    public int increasePrice() {
        return (int) (Math.random() * 500) + 700;
    }

    @Override
    public int decreasePrice() {
        return (int) (Math.random() * 400) + 400;
    }
}
