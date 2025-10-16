package model;

import model.residence.Residence;

import java.util.List;

public class Owner {

    private int id = 1;
    private String name;
    private String contactNumber;
    private String cpf;


    public Owner( String name, String contactNumber, String cpf) {
        this.id = id++;
        this.name = name;
        this.contactNumber = contactNumber;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
