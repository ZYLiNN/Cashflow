package model;

public class HighIncreaseLowDecrease implements StockAlgorithm {

    @Override
    public int increasePrice() {
        return (int) (Math.random() * 500) + 600;
    }

    @Override
    public int decreasePrice() {
        return (int) (Math.random() * 400) + 1;
    }
}
