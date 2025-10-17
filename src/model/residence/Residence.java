package model.residence;

import model.Owner;

import java.util.Optional;

public abstract class Residence {

    private static int idCounter = 1; // contador compartilhado entre todas as residências
    private int id; // id da instância

    // Dados principais
    private String postalCode;
    private int number;

    // Dados do locador + imóvel
    private Owner owner;
    private boolean rented;
    private int rentPrice;
    private Condominium condominium;

    public abstract int getBrokerFee();
    public abstract String getType();

    // Construtor
    public Residence(String postalCode, int number, Owner owner, boolean rented, int rentPrice) {
        this.id = idCounter++;
        this.postalCode = postalCode;
        this.number = number;
        this.owner = owner;
        this.rented = rented;
        this.rentPrice = rentPrice;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n================ RESIDENCE DETAILS ================\n");
        sb.append("🏘️  Residence ID: ").append(id).append("\n");
        sb.append("📍 Address: ").append(postalCode)
                .append(", No. ").append(number).append("\n");
        sb.append("👤 Owner: ").append(owner != null ? owner.getName() : "No owner assigned").append("\n");
        sb.append("💰 Rent Price: R$ ").append(rentPrice).append("\n");
        sb.append("📦 Status: ").append(rented ? "Rented" : "Available").append("\n");
        sb.append("🏷️ Type: ").append(getType()).append("\n"); // <-- adicionando o type

        if (condominium != null) {
            sb.append("🏢 Condominium: ").append(condominium.getName()).append("\n");
        } else {
            sb.append("🏢 Condominium: N/A\n");
        }

        sb.append("💼 Broker Fee: R$ ").append(getBrokerFee()).append("\n");
        sb.append("===================================================\n");

        return sb.toString();
    }


}
