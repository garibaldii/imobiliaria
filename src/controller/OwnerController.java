package controller;


import model.Owner;
import model.residence.Residence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerController {


    //utilizando um meio de armazenamento de dados mais básico, a fim de didática, poderia facilmente estar guardando num banco
    private final List<Owner> owners = new ArrayList<>();


    public Owner login(String name, String cpf) {
        if (name == null || name.isBlank() || cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("Name and CPF must not be empty.");
        }

        return owners.stream()
                .filter(o -> o.getName().equalsIgnoreCase(name) && o.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Login failed. Owner not found with the given name and CPF."));
    }



    // Adiciona um novo owner
    public Owner postOwner(Owner owner) {
        String cpf = owner.getCpf();

        boolean cpfExists = owners.stream()
                .anyMatch(o -> o.getCpf().equals(cpf));

        if (cpfExists) {
            System.out.println("You already have an account with us");
            System.out.println("Try loggin 🤓");
            return null;
        }

        owners.add(owner);
        return owner;
    }


    public Residence addResidence(Residence residence, Owner owner) {


        // garante que a residência sabe quem é o dono
        residence.setOwner(owner);

        // adiciona ao dono também
        owner.getResidences().add(residence);

        return residence;


    }


    public List<Residence> getResidencesByOwner(Owner owner) {
        return owner.getResidences();
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
