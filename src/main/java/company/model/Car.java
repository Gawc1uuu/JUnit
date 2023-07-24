package company.model;

import java.time.LocalDate;

public class Car {

    private String producer;
    private LocalDate productionDate;
    private LocalDate nextServiceDate;

    private Garage garage;
    private Company company;

    public Car(String producer, LocalDate productionDate, LocalDate nextServiceDate) {
        this.producer = producer;
        this.productionDate = productionDate;
        this.nextServiceDate = nextServiceDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDate nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
