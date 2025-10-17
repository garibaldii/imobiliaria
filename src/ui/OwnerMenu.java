package ui;


import controller.ContractController;
import controller.OwnerController;
import controller.TenantController;
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

    OwnerController controller = OwnerController.getInstance();
    TenantController tenantController = TenantController.getInstance();
    ContractController contractController = new ContractController();

    Owner owner;

    ApartmentMenu apMenu = new ApartmentMenu();
    DomesticHouseMenu houseMenu = new DomesticHouseMenu();
    FarmMenu farmMenu = new FarmMenu();

    private final Scanner scanner = new Scanner(System.in);

    public void executeOwnerMenu() {
        var option = -1;

        while (true) {
            System.out.println("Garibaldi's Real Estate Broker: " + "OWNER: " + owner.getName() + "!");
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
                    Apartment ap = apMenu.postApartment(owner);
                    //salva o ap no registro do usuário
                    controller.addResidence(ap, owner.getId());
                }
                case 2 -> {
                    DomesticHouse house = houseMenu.postHouse(owner);
                    controller.addResidence(house, owner.getId());
                }
                case 3 -> {
                    Farm farm = farmMenu.postFarm(owner);
                    controller.addResidence(farm, owner.getId());
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
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        owner = new Owner(name, contactNumber, cpf);

        controller.postOwner(owner);

        System.out.println(owner);
        System.out.println("You owner account was created with sucess 🤓");
        System.out.println("We are redirecting you to your owner's screen...");

        executeOwnerMenu();
    }

    public void updateOwnerData() {
        System.out.println("Let's update your owner account 🤓");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        owner = new Owner(name, contactNumber, cpf);

        controller.updateOwnerById(owner.getId(), owner);

        System.out.println(owner);
        System.out.println("You owner account was updated with sucess 🤓");
        System.out.println("We are redirecting you to your owner's screen...");

    }

    public void showOwnerResidences() {

        if (controller.getResidencesByOwnerId(owner.getId()).isEmpty()) {
            System.out.println("😭 No residences registered []");
            System.out.println("Register them and you could saw it right here 🤓");
            return;
        }

        System.out.println("These are yours residences registered here with us! 🤓");

        System.out.println(controller.getResidencesByOwnerId(owner.getId()));

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
                        owner.getContracts().isEmpty() ? "You have no contracts yet. 🤓" : owner.getContracts()
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
        System.out.println("--- DELETE SECTION ---");
        System.out.println("These are yours residences: ");

        List<Residence> residences = controller.getResidencesByOwnerId(owner.getId());

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

                controller.deleteResidenceById(residence, owner.getId());
                System.out.println("Residence with id " + id + " was deleted successfully.");
                break;
            } else {
                System.out.println("No residence found with id " + id + ". Try again.");
            }
        }


    }

    public void updateResidenceData() {

        List<Tenant> tenants = tenantController.getAllTenants();
        List<Residence> residences = controller.getResidencesByOwnerId(owner.getId());

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
                Contract c = new Contract(owner, tenant, residence, months);

                //alugada
                residence.setRented(true);

                //vinculado
                tenant.setContract(c);

                //adicionado a lista de contratos
                owner.getContracts().add(c);

                contractController.postContract(c);

                System.out.println("Contract Signed with sucess!");
                System.out.println(c);

                return;
            }

        }

    }

}


