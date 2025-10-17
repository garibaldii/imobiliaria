package ui;


import controller.ApartmentController;
import model.Owner;
import model.residence.Apartment;
import model.residence.Residence;
import model.residence.enums.ApartmentType;
import utils.ResidenceUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ApartmentMenu {

    ApartmentController apartmentController = ApartmentController.getInstance();

    private final Scanner scanner = new Scanner(System.in);


    public void showAvailableApartments() {
        List<Apartment> apartments = apartmentController.getApartments()
                .stream()
                .filter(a -> !a.isRented())
                .toList();

        if (apartments.isEmpty()) {
            System.out.println("😭 No available apartments at the moment.");
        }


    }



    public Apartment postApartment(Owner owner) {

        ApartmentType[] types = ApartmentType.values();

        System.out.println("--- Apartment Area ---");
        System.out.println("Lets Rent your apartment!");

        Residence residenceData = ResidenceUtils.collectResidenceData(scanner, owner);

        System.out.println("Floor Number: ");
        int floorNumber = Integer.parseInt(scanner.nextLine());

        ApartmentType selectedType = null;
        while (selectedType == null) {
            System.out.println("Apartment type:");

            //criei um objeto pra facilitar a selecao do index correspondente.
            Map<Integer, ApartmentType> apartmentTypes = new HashMap<>();

            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + " - " + types[i].getLabel());
                apartmentTypes.put(i + 1, types[i]);
            }

            int option = Integer.parseInt(scanner.nextLine());

            if (apartmentTypes.get(option) != null) {
                scanner.nextLine(); // limpar o buffer do Enter
                selectedType = apartmentTypes.get(option);
            }
        }

        boolean hasElevator;
        while (true) {
            System.out.println("Has Elevator? (Y/N)");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                hasElevator = true;
                break;
            } else if (input.equals("N")) {
                hasElevator = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N' .");
            }
        }


        boolean hasBalcony;
        while (true) {
            System.out.println("Has Balcony? (Y/N)");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                hasBalcony = true;
                break;
            } else if (input.equals("N")) {
                hasBalcony = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N' .");
            }
        }

        Apartment apartment = new Apartment(
                residenceData.getPostalCode(),
                residenceData.getNumber(),
                residenceData.getOwner(),
                residenceData.isRented(),
                residenceData.getRentPrice(),
                residenceData.getCondominium(),
                selectedType,
                floorNumber,
                hasElevator,
                hasBalcony
        );
        System.out.println("Apartment posted with sucess!");

        return apartmentController.postApartment(apartment);

    }
}
