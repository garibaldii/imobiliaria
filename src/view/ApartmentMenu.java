package view;

import controller.ApartmentController;
import model.residence.Apartment;
import model.residence.Residence;
import model.residence.enums.ApartmentType;
import utils.ResidenceUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ApartmentMenu {

    ApartmentController apartmentController = new ApartmentController();

    private final Scanner scanner = new Scanner(System.in);


    public String getAvailableApartments() {
        List<Apartment> apartments = apartmentController.getApartments();

        return apartments.stream()
                .filter(a -> !a.isRented()).toString();
    }


    public void postApartment() {

        ApartmentType[] types = ApartmentType.values();

        System.out.println("--- Apartment Area ---");
        System.out.println("Lets Rent your apartment!");

        Residence residenceData = ResidenceUtils.collectResidenceData(scanner);

        System.out.println("Floor Number: ");
        int floorNumber = scanner.nextInt();

        ApartmentType selectedType = null;
        while (selectedType == null) {
            System.out.println("Apartment type:");

            //criei um objeto pra facilitar a selecao do index correspondente.
            Map<Integer, ApartmentType> apartmentTypes = new HashMap<>();

            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + " - " + types[i].getLabel());
                apartmentTypes.put(i + 1, types[i]);
            }

            int option = scanner.nextInt();

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

        apartmentController.postApartment(apartment);

        System.out.println("Apartment posted with sucess!");
    }
}
