package company.model;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", productionDate=" + productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(productionDate, car.productionDate) && Objects.equals(nextServiceDate, car.nextServiceDate) && Objects.equals(garage, car.garage) && Objects.equals(company, car.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, productionDate, nextServiceDate, garage, company);
    }
}
