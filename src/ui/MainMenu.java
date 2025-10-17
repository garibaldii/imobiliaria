package ui;

import java.util.Scanner;

public class MainMenu {

    //    ApartmentController apartmentController = new ApartmentController();
    ApartmentMenu apMenu = new ApartmentMenu();
    OwnerMenu ownerMenu = new OwnerMenu();
    DomesticHouseMenu houseMenu = new DomesticHouseMenu();
    TenantMenu tenantMenu = new TenantMenu();
    FarmMenu farmMenu = new FarmMenu();


    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        var option = -1;

        while (true) {
            System.out.println("Garibaldi's Real Estate Broker - MAIN MENU");
            System.out.println("🤓 How can i help you?");
            System.out.println("1 - Renting");
            System.out.println("2 - Tenant Area");
            System.out.println("3 - Owner Area");
            System.out.println("4 - Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> rentingOption();
                case 2 -> tenantOption();
                case 3 -> userOption();
                case 4 -> {
                    System.out.println("Thanks for visiting! We appreciate your presence!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Option, please choose a valid option in menu");
            }
        }
    }

    public void rentingOption() {
        System.out.println("--- Renting Area ---");
        System.out.println("What are you interest in?");
        var option = -1;

        while (true) {
            System.out.println("1 - Domestic Houses");
            System.out.println("2 - Apartments");
            System.out.println("3 - Farms/Country Houses");
            System.out.println("4 - Go Back");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> houseMenu.showAvailableHouses();
                case 2 -> apMenu.showAvailableApartments();
                case 3 -> farmMenu.showAvailableFarms();
                case 4 -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    public void tenantOption() {


        var option = -1;

        while (true) {
            System.out.println("--- Tenant Area ---");
            System.out.println("Please select an option");
            System.out.println("1 - Login");
            System.out.println("2 - Create account");
            System.out.println("3 - Exit");


            option = scanner.nextInt();

            switch (option) {
                case 1 -> System.out.println("On developmenting... 🤓");
                case 2 -> tenantMenu.registerTenant();
                case 3 -> {
                    System.out.println("Exiting tenant area...");
                    return;
                }
                default -> System.out.println("Invalid Option, please choose a valid option in menu");
            }
        }
    }

    public void userOption() {

        var option = -1;


        while (true) {
            System.out.println("--- Owner Area ---");
            System.out.println("Please select an option");
            System.out.println("1 - Login");
            System.out.println("2 - Create an account");
            System.out.println("3 - Go Back");

            option = scanner.nextInt();

            switch (option) {
//                case 1 -> ;
                case 2 -> ownerMenu.registerOwner();
                case 3 -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid option, try again");
            }
        }
    }


}