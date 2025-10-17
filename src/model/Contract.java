package model;

import model.residence.Residence;

public class Contract {

    private Owner residenceOwner;
    private Tenant residenceTenant;
    private Residence residence;
    private int months;
    private int contractPrice;

    public Contract(Owner residenceOwner, Tenant residenceTenant, Residence residence, int months) {
        this.residenceOwner = residenceOwner;
        this.residenceTenant = residenceTenant;
        this.residence = residence;
        this.months = months;
        this.contractPrice = residence.getBrokerFee() * months;
    }

    public Owner getResidenceOwner() {
        return residenceOwner;
    }

    public void setResidenceOwner(Owner residenceOwner) {
        this.residenceOwner = residenceOwner;
    }

    public Tenant getResidenceTenant() {
        return residenceTenant;
    }

    public void setResidenceTenant(Tenant residenceTenant) {
        this.residenceTenant = residenceTenant;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(int contractPrice) {
        this.contractPrice = contractPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n================ CONTRACT DETAILS ================\n");
        sb.append("🏠 Residence: ").append(residence.getClass().getSimpleName()).append("\n");
        sb.append("📍 Address: ").append(residence.getPostalCode())
                .append(", No. ").append(residence.getNumber()).append("\n");
        sb.append("👤 Owner: ").append(residenceOwner.getName())
                .append(" (CPF: ").append(residenceOwner.getCpf()).append(")\n");
        sb.append("🙋 Tenant: ").append(residenceTenant.getName())
                .append(" (CPF: ").append(residenceTenant.getCpf()).append(")\n");
        sb.append("🗓️ Duration: ").append(months).append(" month").append(months > 1 ? "s" : "").append("\n");
        sb.append("💰 Monthly Rent: R$ ").append(residence.getBrokerFee()).append("\n");
        sb.append("💵 Total Contract Price: R$ ").append(contractPrice).append("\n");
        sb.append("=================================================\n");

        return sb.toString();
    }

}
