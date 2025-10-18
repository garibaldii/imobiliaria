package model;

public class Tenant {
    private static int idCounter = 1; // contador compartilhado entre todas as residências
    private int id;
    private String name;
    private String cpf;
    private Contract contract;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Tenant(String name, String cpf) {
        this.id = idCounter++;
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n================ TENANT DETAILS ================\n");
        sb.append("🆔 Tenant ID: ").append(id).append("\n");
        sb.append("🙋 Name: ").append(name).append("\n");
        if (contract != null) {
            sb.append("📜 Contract Linked: YES\n");
            sb.append("🏠 Residence Type: ").append(contract.getResidence().getClass().getSimpleName()).append("\n");
            sb.append("💰 Total Contract Value: R$ ").append(contract.getContractPrice()).append("\n");
        } else {
            sb.append("📜 Contract Linked: NO\n");
        }

        sb.append("===============================================\n");

        return sb.toString();
    }

}
