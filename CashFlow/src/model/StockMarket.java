package model;

import java.util.List;

public class StockMarket extends Market {

    public StockMarket(CompaniesRepository companiesRepository) {
        super(companiesRepository);
        this.companiesRepository = companiesRepository;
        setUpCompanies();
    }

    private void setUpCompanies() {
        companies = companiesRepository.createCompanies();
    }

    @Override
    public void showInfo() {
        System.out.printf("%4s%5s%6s\n", "公司名稱", "ID", "股價");
        for(Company company : companies) {
            System.out.printf("%s%8d%6d\n",company.getName(), company.getId(), company.getStockPrice());
        }
    }

}
