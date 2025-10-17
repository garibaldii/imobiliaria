package ui;

import actions.validator.InputValidator;
import controller.TenantController;
import model.Owner;
import model.Tenant;

import java.util.Scanner;

public class TenantMenu {

    private final TenantController controller = TenantController.getInstance();
    private Tenant sessionTenant;

    DomesticHouseMenu houseMenu = new DomesticHouseMenu();
    FarmMenu farmMenu = new FarmMenu();
    ApartmentMenu apMenu = new ApartmentMenu();


    private final Scanner scanner = new Scanner(System.in);

    public void tenantLogin() {
        System.out.println("--- Tenant Login ---");

        String name = InputValidator.readValidName();

        String cpf = InputValidator.readValidCPF();

        Tenant loggedTenant = controller.login(name, cpf);


        sessionTenant = loggedTenant;
        System.out.println("Login successful! Redirecting to your dashboard...");
        executeTenantMenu();
//        } else {
//            System.out.println("Login failed. Do you want to try again? (Y/N)");
//            String option = scanner.nextLine().trim().toUpperCase();
//            if (option.equals("Y")) {
//                ownerLogin();
//            } else {
//                System.out.println("Exiting Owner login...");
//            }
//        }
    }


    public void registerTenant() {
        System.out.println("Let's create your tenant account 🏠");

        String name = InputValidator.readValidName();

        String cpf = InputValidator.readValidCPF();

        sessionTenant = new Tenant(name, cpf);
        controller.postTenant(sessionTenant);

        System.out.println();
        System.out.println("Tenant account created successfully 🎉");
        System.out.println("Redirecting you to your tenant screen...");

        System.out.println(controller.getAllTenants());

        executeTenantMenu();
    }

    public void executeTenantMenu() {
        int option = -1;

        while (true) {
            System.out.println("Garibaldi's Real Estate Broker: " + "WELCOME " + sessionTenant.getName() + "!");
            System.out.println("🏡 How can I help you?");
            System.out.println("1 - View Apartments");
            System.out.println("2 - View Domestic Houses");
            System.out.println("3 - View Farms");
            System.out.println("4 - View My Contracts");
            System.out.println("5 - Update My Data");
            System.out.println("6 - Exit");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> apMenu.showAvailableApartments();
                case 2 -> houseMenu.showAvailableHouses();
                case 3 -> farmMenu.showAvailableFarms();
                case 4 -> viewContracts();
                case 5 -> updateTenantData();
                case 6 -> {
                    System.out.println("Thanks for visiting! We appreciate your presence!");
                    return;
                }
                default -> System.out.println("Invalid option, please choose a valid one!");
            }
        }
    }

    private void viewContracts() {
        System.out.println("📜 Showing your contracts...");
        if (sessionTenant.getContract() == null) {
            System.out.println("You have no contracts yet.");
        } else {
            System.out.println(sessionTenant.getContract());
        }
    }

    private void updateTenantData() {
        System.out.println("✏️ Update your data");
        scanner.nextLine(); // limpa buffer

        String name = InputValidator.readValidName();

        String cpf = InputValidator.readValidCPF();

        Tenant updatedData = new Tenant(name, cpf);

        controller.updateTenantById(sessionTenant.getId(),updatedData);

        System.out.println(updatedData);

        System.out.println("✅ Tenant data updated successfully!");
    }
}
