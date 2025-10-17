package controller;


import model.Owner;
import model.residence.Residence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerController {

    private static final OwnerController instance = new OwnerController();

    public static OwnerController getInstance(){
        return instance;
    }



    //utilizando um meio de armazenamento de dados mais básico, a fim de didática, poderia facilmente estar guardando num banco
    private final List<Owner> owners = new ArrayList<>();

    // Adiciona um novo owner
    public Owner postOwner(Owner owner) {
        owners.add(owner);
        return owner;
    }

    public Residence addResidence(Residence residence, int ownerId) {
        Optional<Owner> optOwner = getOwnerById(ownerId);

        if (optOwner.isPresent()) {
            Owner owner = optOwner.get();
            owner.getResidences().add(residence);

            return residence;
        }
        return null;
    }

    public List<Residence> getResidencesByOwnerId(int ownerId) {
        return getOwnerById(ownerId)
                .map(Owner::getResidences)
                .orElseGet(() -> {
                    System.out.println("Owner not found with ID: " + ownerId);
                    return List.of(); // retorna lista vazia
                });
    }


    // Busca owner por ID
    public Optional<Owner> getOwnerById(int id) {
        return owners.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    public boolean deleteResidenceById(Residence residence, int ownerId) {
        Optional<Owner> ownerOpt = getOwnerById(ownerId);

        if (ownerOpt.isPresent()) {
            //precisaria também remover a residencia da lista correspondente...
            //por exemplo aqui estamos removendo somente do vinculo com o usuário, e nao a sua existência
            Owner owner = ownerOpt.get();
            return owner.getResidences().remove(residence);
        }

        return false;
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

}
