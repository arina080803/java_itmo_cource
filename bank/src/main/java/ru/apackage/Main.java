package ru.apackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bank ===");
        while (true) {
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show balance");
            System.out.println("5. History");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");
            var choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Input ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.createAccount(id);
                        System.out.println("Account created.");
                        break;
                    case "2":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Amount: ");
                        double dep = Double.parseDouble(scanner.nextLine());
                        manager.deposit(id, dep);
                        break;
                    case "3":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Amount: ");
                        double wd = Double.parseDouble(scanner.nextLine());
                        manager.withdraw(id, wd);
                        break;
                    case "4":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Balance: " + manager.getBalance(id));
                        break;
                    case "5":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        manager.printHistory(id);
                        break;
                    case "0":
                        System.out.println("Exit...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Wrong choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
