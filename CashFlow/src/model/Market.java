package model;

import java.util.List;

public abstract class Market {
    CompaniesRepository companiesRepository;
    List<Company> companies;

    public Market(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
        companies = companiesRepository.createCompanies();
    }

    public abstract void showInfo();

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
