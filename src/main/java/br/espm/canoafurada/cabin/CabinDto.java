package br.espm.canoafurada.cabin;

import java.util.UUID;

public class CabinDto {
    private UUID id;
    private int maxPeople;
    private double pricePerson;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(double pricePerson) {
        this.pricePerson = pricePerson;
    }
}
