package actions.validator;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readValidName() {
        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                return name;
            } else {
                System.out.println("Invalid name. Only letters and spaces are allowed.");
            }
        }
    }

    public static String readValidPhoneNumber() {
        String phone;
        while (true) {
            System.out.print("Phone Number: ");
            phone = scanner.nextLine().trim();
            if (phone.matches("\\d{8,15}")) {
                return phone;
            } else {
                System.out.println("Invalid phone number. Only digits allowed (8-15 digits).");
            }
        }
    }

    public static String readValidCPF() {
        String cpf;
        while (true) {
            System.out.print("CPF: ");
            cpf = scanner.nextLine().trim();
            if (cpf.matches("\\d{11}")) {
                return cpf;
            } else {
                System.out.println("Invalid CPF. It must contain exactly 11 digits.");
            }
        }
    }

    public static int readPositiveInt() {
        int value;
        while (true) {
            System.out.println("Number: ");
            String input = scanner.nextLine().trim();
            try {
                value = Integer.parseInt(input);
                if (value > 0) return value;
                else System.out.println("Value must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a positive integer.");
            }
        }
    }
}
