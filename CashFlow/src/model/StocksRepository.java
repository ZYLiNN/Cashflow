package model;

import java.util.HashMap;

public interface StocksRepository {
    HashMap<Integer, Stock> createCompanies();
}
