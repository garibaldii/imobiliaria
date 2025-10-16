package view;

import controller.OwnerController;
import model.Owner;

import java.util.Scanner;

public class OwnerMenu {

    OwnerController controller = new OwnerController();
    Owner owner;

    ApartmentMenu apMenu = new ApartmentMenu();

    private final Scanner scanner = new Scanner(System.in);

    public void registerOwner() {
        System.out.println("Let's create your owner account 🤓");



        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        owner = new Owner(name, contactNumber, cpf);


        System.out.println(owner);
        System.out.println("You owner account was created with sucess 🤓");
        System.out.println("We are redirecting you to your owner's screen...");

        executeOwnerMenu();
    }

    public void executeOwnerMenu() {
        System.out.println("Garibaldi's Real Estate Broker: " + "WELCOME " + owner.getName() + "!");
        var option = -1;

        while (true) {
            System.out.println("🤓 How can i help you?");
            System.out.println("1 - Anounce Apartment");
            System.out.println("2 - Anounce Domestic House");
            System.out.println("3 - Anounce Farm");
            System.out.println("4 - My residences");
            System.out.println("4 - Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> apMenu.postApartment();
//                case 2 -> TenantOption();
//                case 3 -> userOption();
                case 4 -> {
                    System.out.println("Thanks for visiting! We appreciate your presence!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Option, please choose a valid option in menu");
            }
        }
    }

}
