package model;

import java.util.ArrayList;
import java.util.List;

public class CompaniesRepositoryImp implements CompaniesRepository {
    private List<Company> companies = new ArrayList<>();

    public CompaniesRepositoryImp() {
    }

    @Override
    public List<Company> createCompanies() {
        companies.add(new Company(1, "紅海"));
        companies.add(new Company(2, "台積店"));
        companies.add(new Company(3, "藤訊"));
        companies.add(new Company(4, "宏達墊"));
        companies.add(new Company(5, "頻果"));
        return companies;
    }

}
