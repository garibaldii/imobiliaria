package ui;

import controller.TenantController;
import model.Tenant;

import java.util.Scanner;

public class TenantMenu {

    private final TenantController controller = TenantController.getInstance();
    private Tenant tenant;

    DomesticHouseMenu houseMenu = new DomesticHouseMenu();
    FarmMenu farmMenu = new FarmMenu();
    ApartmentMenu apMenu = new ApartmentMenu();


    private final Scanner scanner = new Scanner(System.in);

    public void registerTenant() {
        System.out.println("Let's create your tenant account 🏠");
        scanner.nextLine(); // limpa buffer

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        tenant = new Tenant(name, cpf);
        controller.postTenant(tenant);

        System.out.println();
        System.out.println("Tenant account created successfully 🎉");
        System.out.println("Redirecting you to your tenant screen...");

        System.out.println(controller.getAllTenants());

        executeTenantMenu();
    }

    public void executeTenantMenu() {
        System.out.println("Garibaldi's Real Estate Broker: " + "WELCOME " + tenant.getName() + "!");
        int option = -1;

        while (true) {
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
        if (tenant.getContract() == null) {
            System.out.println("You have no contracts yet.");
        } else {
            System.out.println(tenant.getContract());
        }
    }

    private void updateTenantData() {
        System.out.println("✏️ Update your data");
        scanner.nextLine(); // limpa buffer

        System.out.print("New Name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) tenant.setName(name);

        System.out.print("New CPF (leave blank to keep current): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty()) tenant.setCpf(cpf);

        System.out.println("✅ Tenant data updated successfully!");
    }
}
