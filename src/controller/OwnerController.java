package controller;


import model.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerController {

    private final List<Owner> owners = new ArrayList<>();

    // Adiciona um novo owner
    public Owner postOwner(Owner owner) {
        owners.add(owner);

        return owner;

    }

    // Busca owner por ID
    public Optional<Owner> getOwnerById(int id) {
        return owners.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    // Atualiza owner existente
    public Owner updateOwnerById(int id, Owner data) {
        Optional<Owner> ownerOptional = getOwnerById(id);

        if (ownerOptional.isPresent()) {
            Owner owner = ownerOptional.get();
            owner.setName(data.getName());
            owner.setContactNumber(data.getContactNumber());
            owner.setCpf(data.getCpf());
            return owner;
        } else {
            System.out.println("Owner not found");
            return null;
        }
    }

    // Retorna todos os owners
    public List<Owner> getAllOwners() {
        return owners;
    }
}
