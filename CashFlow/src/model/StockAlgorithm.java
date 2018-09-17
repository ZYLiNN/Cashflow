package model;

import java.io.Serializable;

public interface StockAlgorithm extends Serializable {
    int increasePrice();
    int decreasePrice();
}
