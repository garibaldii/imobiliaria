package ui;

import controller.DomesticHouseController;
import model.Owner;
import model.residence.Apartment;
import model.residence.DomesticHouse;
import model.residence.Residence;
import model.residence.enums.HouseType;
import utils.ResidenceUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DomesticHouseMenu {

    private final Scanner scanner = new Scanner(System.in);
    DomesticHouseController controller = new DomesticHouseController();

    public DomesticHouse postHouse(Owner owner) {

        HouseType[] types = HouseType.values();

        System.out.println("--- Domestic House Area ---");
        System.out.println("Lets Rent your house!");

        Residence residenceData = ResidenceUtils.collectResidenceData(scanner, owner);

        HouseType selectedType = null;
        while (selectedType == null) {
            System.out.println("House type:");

            //criei um objeto pra facilitar a selecao do index correspondente.
            Map<Integer, HouseType> houseTypes = new HashMap<>();

            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + " - " + types[i].getLabel());
                houseTypes.put(i + 1, types[i]);
            }

            int option = Integer.parseInt(scanner.nextLine());

            if (houseTypes.get(option) != null) {
                scanner.nextLine(); // limpar o buffer do Enter
                selectedType = houseTypes.get(option);
            }
        }

        boolean hasPool;
        while (true) {
            System.out.println("Has Pool? (Y/N)");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                hasPool = true;
                break;
            } else if (input.equals("N")) {
                hasPool = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N' .");
            }
        }


        DomesticHouse house = new DomesticHouse(
                residenceData.getPostalCode(),
                residenceData.getNumber(),
                residenceData.getOwner(),
                residenceData.isRented(),
                residenceData.getRentPrice(),
                selectedType,
                hasPool
        );
        System.out.println("House posted with sucess!");

        return controller.postDomesticHouse(house);

    }

    public void showAvailableHouses() {
        List<DomesticHouse> houses = controller.getAvailableHouses()
                .stream()
                .filter(h -> !h.isRented())
                .toList();

        if (houses.isEmpty()) {
            System.out.println("😭 No available houses at the moment.");
            return;
        }

        System.out.println("🏡 Available Houses:");
        for (DomesticHouse house : houses) {
            System.out.println("=======================================");
            System.out.println("House ID: " + house.getId());
            System.out.println("Address: " + house.getPostalCode() + ", No. " + house.getNumber());
            System.out.println("Rent Price: R$ " + house.getRentPrice());
            System.out.println("Type: " + house.getType());
            System.out.println("Has Pool: " + (house.isHasPool() ? "Yes" : "No"));
            System.out.println("=======================================\n");
        }
    }

}
