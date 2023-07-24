package company.model;

public class FinancialPenalty {
    private String name;
    private String description;
    private double amount;
    private Company company;

    public FinancialPenalty(String name, String description, double amount, Company company) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.company = company;
        company.getFinancialPenalties().add(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
