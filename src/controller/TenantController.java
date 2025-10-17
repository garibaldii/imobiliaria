package controller;

import model.Owner;
import model.Tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TenantController {

    private static final TenantController instance = new TenantController();

    public static TenantController getInstance() {
        return instance;
    }

    private final List<Tenant> tenants = new ArrayList<>();



    public Tenant login(String name, String cpf) {
        if (name == null || name.isBlank() || cpf == null || cpf.isBlank()) {
            System.out.println("Name and CPF must not be empty.");
            return null;
        }

        Optional<Tenant> ownerOpt = tenants.stream()
                .filter(o -> o.getName().equalsIgnoreCase(name) && o.getCpf().equals(cpf))
                .findFirst();

        if (ownerOpt.isPresent()) {
            System.out.println("Login successful! Welcome " + name + "!");
            return ownerOpt.get();
        } else {
            System.out.println("Login failed. Owner not found with the given name and CPF.");
            return null;
        }
    }



    public Tenant postTenant(Tenant t) {
        tenants.add(t);
        return t;
    }
    public List<Tenant> getAllTenants(){
        return this.tenants;
    }


    public Optional<Tenant> getTenantById(int id) {
        return tenants.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    // Atualiza TENANT existente
    public Tenant updateTenantById(int id, Tenant data) {
        Optional<Tenant> tenantOptional = getTenantById(id);

        if (tenantOptional.isPresent()) {
            Tenant tenant = tenantOptional.get();
            tenant.setName(data.getName());
            tenant.setCpf(data.getCpf());
            return tenant;
        } else {
            System.out.println("Tenant not found");
            return null;
        }
    }
}
