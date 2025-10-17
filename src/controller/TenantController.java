package controller;

import model.Tenant;

import java.util.ArrayList;
import java.util.List;

public class TenantController {

    private static final TenantController instance = new TenantController();

    public static TenantController getInstance() {
        return instance;
    }

    private final List<Tenant> tenants = new ArrayList<>();

    public Tenant postTenant(Tenant t) {
        tenants.add(t);
        return t;
    }

    public List<Tenant> getAllTenants(){
        return this.tenants;
    }


}
