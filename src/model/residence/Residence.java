package model.residence;

import model.Owner;

import java.util.Optional;

public abstract class Residence {

    // Dados principais
    private String postalCode;
    private int number;

    // Dados do locador + imovel
    private Owner owner;
    private boolean rented;
    private int rentPrice;
    private Condominium condominium;

    // Construtor
    public Residence(String postalCode, int number, Owner owner, boolean rented, int rentPrice) {
        this.postalCode = postalCode;
        this.number = number;
        this.owner = owner;
        this.rented = rented;
        this.rentPrice = rentPrice;

    }

    // Getters e Setters
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Optional<Condominium> getCondominium() {
        return Optional.ofNullable(condominium);
    }

    public void setCondominium(Condominium condominium) {
        this.condominium = condominium;
    }
}
