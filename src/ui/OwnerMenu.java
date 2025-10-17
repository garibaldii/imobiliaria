package ui;


import actions.validator.InputValidator;
import controller.*;
import model.Contract;
import model.Owner;
import model.Tenant;
import model.residence.Apartment;
import model.residence.DomesticHouse;
import model.residence.Farm;
import model.residence.Residence;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OwnerMenu {

    OwnerController controller = new OwnerController();
    TenantController tenantController = TenantController.getInstance();
    ContractController contractController = new ContractController();
    ApartmentController apController = ApartmentController.getInstance();
    DomesticHouseController domesticHouseController = DomesticHouseController.getInstance();
    FarmController farmController = FarmController.getInstance();

    Owner sessionOwner;

    ApartmentMenu apMenu = new ApartmentMenu();
    DomesticHouseMenu houseMenu = new DomesticHouseMenu();
    FarmMenu farmMenu = new FarmMenu();

    private final Scanner scanner = new Scanner(System.in);

    public void ownerLogin() {
        System.out.println("--- Owner Login --- 🔏");

        String name = InputValidator.readValidName();

        String cpf = InputValidator.readValidCPF();

        Owner loggedOwner = controller.login(name, cpf);


            sessionOwner = loggedOwner;
            System.out.println("Login successful! Redirecting to your dashboard...");
            executeOwnerMenu();

    }

    public void executeOwnerMenu() {
        var option = -1;

        while (true) {
            System.out.println("Garibaldi's Real Estate Broker: " + "OWNER: " + sessionOwner.getName() + "! 🏡");
            System.out.println("🤓 How can i help you?");
            System.out.println("1 - Anounce Apartment");
            System.out.println("2 - Anounce Domestic House");
            System.out.println("3 - Anounce Farm");
            System.out.println("4 - My residences");
            System.out.println("5 - Update data");
            System.out.println("6 - Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    //salva o ap na tabela
                    Apartment ap = apMenu.postApartment(sessionOwner);
                    //salva o ap no registro do usuário
                    controller.addResidence(ap, sessionOwner);
                }
                case 2 -> {
                    DomesticHouse house = houseMenu.postHouse(sessionOwner);
                    controller.addResidence(house, sessionOwner);
                }
                case 3 -> {
                    Farm farm = farmMenu.postFarm(sessionOwner);
                    controller.addResidence(farm, sessionOwner);
                }
                case 4 -> showOwnerResidences();
                case 5 -> updateOwnerData();
                case 6 -> {
                    System.out.println("Thanks for visiting! We appreciate your presence!");
                    return;
                }
                default -> System.out.println("Invalid Option, please choose a valid option in menu");
            }
        }
    }

    public void registerOwner() {
        System.out.println("Let's create your owner account 🤓");

        //validacao entrada nome
        String name = InputValidator.readValidName();

        //validacao entrada numeroTelefone
        String contactNumber = InputValidator.readValidPhoneNumber();

        //validacao entrada cpf
        String cpf = InputValidator.readValidCPF();

        Owner registeredOwner = new Owner(name, contactNumber, cpf);

        controller.postOwner(registeredOwner);


        System.out.println(registeredOwner);
        System.out.println("You owner account was created with sucess 🤓");
        System.out.println("We are redirecting you to login screen...");


        ownerLogin();
    }

    public void updateOwnerData() {
        System.out.println("Let's update your owner account 🤓");

        System.out.print("Name: ");
        String name = InputValidator.readValidName();

        System.out.print("Phone Number: ");
        String contactNumber = InputValidator.readValidPhoneNumber();

        System.out.print("CPF: ");
        String cpf = InputValidator.readValidCPF();

        sessionOwner = new Owner(name, contactNumber, cpf);

        controller.updateOwnerById(sessionOwner.getId(), sessionOwner);

        System.out.println(sessionOwner);
        System.out.println("You owner account was updated with sucess 🤓");
        System.out.println("We are redirecting you to your owner's screen...");

    }

    public void showOwnerResidences() {

        if (controller.getResidencesByOwner(sessionOwner).isEmpty()) {
            System.out.println("😭 No residences registered []");
            System.out.println("Register them and you could saw it right here 🤓");
            return;
        }

        System.out.println("These are yours residences registered here with us! 🤓");

        System.out.println(controller.getResidencesByOwner(sessionOwner));

        var option = -1;

        while (true) {
            System.out.println("ACTIONS");
            System.out.println("1 - Sign a rent contract 😍");
            System.out.println("2 - Delete Residence 🗑️");
            System.out.println("3 - My Contracts 📃");
            System.out.println("4 - Go Back");

            option = scanner.nextInt();


            switch (option) {
                case 1 -> updateResidenceData();
                case 2 -> deleteResidence();
                case 3 -> System.out.println(
                        sessionOwner.getContracts().isEmpty() ? "You have no contracts yet. 🤓" : sessionOwner.getContracts()
                );
                case 4 -> {
                    System.out.println("Exiting my residences page...");
                    return;
                }
                default -> System.out.println("Invalid Option, please choose a valid option in menu");
            }

        }
    }


    public void deleteResidence() {
        System.out.println("--- DELETE SECTION --- 🗑️");
        System.out.println("These are yours residences: ");

        List<Residence> residences = controller.getResidencesByOwner(sessionOwner);

        System.out.println(residences);


        while (true) {
            System.out.println("Please enter the id of the residence that you want to delete: ");
            int id = scanner.nextInt();

            // verifica se existe uma residence com esse id
            Optional<Residence> residenceOpt = residences.stream()
                    .filter(r -> r.getId() == id)
                    .findFirst();

            if (residenceOpt.isPresent()) {
                Residence residence = residenceOpt.get();

                if(residence.isRented()){
                    System.out.println("You can't delete a residence that is rented ☠️");
                }

                controller.deleteResidenceById(residence, sessionOwner.getId());

                //uma outra ideia seria fazer por poliformismo.
                //adicionar um metodo abstrato delete na classe residence, e reescrevê-lo em cada classe, chamando seu
                //controlador específico...Porém, no meu entendimento isto misturaria as obrigações da regra de negócio, com
                //os controladores.

                //esta nao é a melhor forma de se fazer, porém, dado o prazo, é o que consegui pensar até então.
                //desta forma, as extensoras de residence, irão ser deletadas de seus respectivos bancos de dados...
                //porém, caso o sistema ficasse mais complexo, teria que adicionar manualmente as "instanceof" dentro de
                //cada if, não sendo bem escrito.
                if(residence instanceof  Apartment){
                    apController.deleteApartment((Apartment) residence);
                } else if (residence instanceof DomesticHouse) {
                    domesticHouseController.deleteHouse((DomesticHouse) residence);
                } else if (residence instanceof Farm) {
                    farmController.deleteFarm((Farm) residence);
                }

                System.out.println("Residence with id " + id + " was deleted successfully.");
                break;
            } else {
                System.out.println("No residence found with id " + id + ". Try again.");
            }
        }


    }

    public void updateResidenceData() {

        List<Tenant> tenants = tenantController.getAllTenants();
        List<Residence> residences = controller.getResidencesByOwner(sessionOwner);

        System.out.println(tenants);


        while (true) {
            System.out.println("Lets Sign your rent contract! 📃");
            System.out.println("--- Tenant Section ---");
            System.out.println("Please insert your tenant id: ");
            int tenantId = scanner.nextInt();

            Optional<Tenant> tenantOpt = tenants.stream()
                    .filter(t -> t.getId() == tenantId)
                    .findFirst();

            System.out.println("--- Residence Section ---");
            System.out.println("Please insert your residence id: ");
            int residenceId = scanner.nextInt();


            Optional<Residence> residenceOpt = residences.stream()
                    .filter(r -> r.getId() == residenceId)
                    .findFirst();

            if (tenantOpt.isEmpty() && residenceOpt.isEmpty()) {
                System.out.println("Tenant or Residence id doesn't exists! ");
                return;

            }

            System.out.println("--- Contract Terms ---");

            System.out.println("How many months your contract will be followed?");
            int months = scanner.nextInt();


            if (tenantOpt.isPresent() && residenceOpt.isPresent() && months > 0) {
                Tenant tenant = tenantOpt.get();
                Residence residence = residenceOpt.get();

                System.out.println("Signing your contract... 📃");
                Contract c = new Contract(sessionOwner, tenant, residence, months);

                //alugada
                residence.setRented(true);

                //vinculado
                tenant.setContract(c);

                //adicionado a lista de contratos
                sessionOwner.getContracts().add(c);

                contractController.postContract(c);

                System.out.println("Contract Signed with sucess!");
                System.out.println(c);

                return;
            } else {
                System.out.println("ERROR");
                return;
            }

        }

    }

}


