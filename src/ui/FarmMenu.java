package ui;

import controller.FarmController;
import model.Owner;
import model.residence.Farm;
import model.residence.Residence;
import model.residence.enums.FarmType;
import actions.utils.ResidenceUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FarmMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final FarmController controller = FarmController.getInstance();

    public Farm postFarm(Owner owner) {

        FarmType[] types = FarmType.values();

        System.out.println("--- Farm Area --- 👨‍🌾");
        System.out.println("Let's post your farm! 🐄");

        // coletando dados básicos do Residence
        Residence residenceData = ResidenceUtils.collectResidenceData(scanner, owner);

        // seleção do tipo de fazenda
        FarmType selectedType = null;
        while (selectedType == null) {
            System.out.println("Farm type:");

            Map<Integer, FarmType> farmTypes = new HashMap<>();
            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + " - " + types[i].getLabel());
                farmTypes.put(i + 1, types[i]);
            }

            int option = Integer.parseInt(scanner.nextLine());
            if (farmTypes.get(option) != null) {
                selectedType = farmTypes.get(option);
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        // criar o objeto Farm
        Farm farm = new Farm(
                residenceData.getPostalCode(),
                residenceData.getNumber(),
                residenceData.getOwner(),
                residenceData.isRented(),
                residenceData.getRentPrice(),
                selectedType
        );

        System.out.println("Farm posted with success! 🌾");

        return controller.postFarm(farm);
    }

    public void showAvailableFarms() {
        List<Farm> farms = controller.getAllFarms()
                .stream()
                .filter(f -> !f.isRented())
                .toList();

        if (farms.isEmpty()) {
            System.out.println("😭 No available farms at the moment.");
        }


    }

}
