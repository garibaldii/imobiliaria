package utils;

import controller.OwnerController;
import model.Owner;
import model.residence.Condominium;
import model.residence.Residence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResidenceUtils {

    public static Residence collectResidenceData(Scanner scanner) {

        System.out.println("--- Residence Data ---");

        // --- Dados básicos ---
        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());

        // --- Dados básicos ---
        System.out.print("Postal Code: ");
        String postalCode = scanner.nextLine();

        System.out.print("Number: ");
        int number = Integer.parseInt(scanner.nextLine());

        // --- Dados do proprietário ---
        System.out.print("Owner Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Owner Phone: ");
        String ownerPhone = scanner.nextLine();

        System.out.print("Owner CPF: ");
        String ownerCPF = scanner.nextLine();

        Owner owner = new Owner(ownerName, ownerPhone, ownerCPF);

        OwnerController controller = new OwnerController();
        controller.postOwner(owner);

        // --- Dados do aluguel ---
        System.out.print("Rent Price: ");
        int rentPrice = Integer.parseInt(scanner.nextLine());

        boolean rented = false; // inicializa como disponível

//        System.out.println("Condominium?");
//        Condominium condominium = null; // opcional, sem condomínio por enquanto


        Residence temp = new Residence(postalCode, number, owner, rented, rentPrice) {};
        return temp;
    }
}
