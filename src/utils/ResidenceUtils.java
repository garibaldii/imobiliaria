package utils;

import model.Owner;
import model.residence.Residence;


import java.util.Scanner;

public class ResidenceUtils {

    public static Residence collectResidenceData(Scanner scanner, Owner owner) {

        System.out.println("--- Residence Data ---");

        // --- Dados básicos ---
        System.out.print("Postal Code: ");
        String postalCode = scanner.nextLine();

        System.out.print("Number: ");
        int number = Integer.parseInt(scanner.nextLine());

        // --- Dados do aluguel ---
        System.out.print("Rent Price: ");
        int rentPrice = Integer.parseInt(scanner.nextLine());

        boolean rented = false; // inicializa como disponível

//        System.out.println("Condominium?");
//        Condominium condominium = null; // opcional, sem condomínio por enquanto


        Residence temp = new Residence(postalCode, number, owner, rented, rentPrice) {
            @Override
            public int getBrokerFee() {
                return 0;
            }

            @Override
            public String getType() {
                return "";
            }
        };
        return temp;
    }
}
