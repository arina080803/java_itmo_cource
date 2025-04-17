package ru.apackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Банкомат ===");
        while (true) {
            System.out.println("\n1. Создать счёт");
            System.out.println("2. Пополнить");
            System.out.println("3. Снять");
            System.out.println("4. Баланс");
            System.out.println("5. История");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Введите ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.createAccount(id);
                        System.out.println("Счёт создан.");
                        break;
                    case "2":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Сумма: ");
                        double dep = Double.parseDouble(scanner.nextLine());
                        manager.deposit(id, dep);
                        break;
                    case "3":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Сумма: ");
                        double wd = Double.parseDouble(scanner.nextLine());
                        manager.withdraw(id, wd);
                        break;
                    case "4":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Баланс: " + manager.getBalance(id));
                        break;
                    case "5":
                        System.out.print("ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        manager.printHistory(id);
                        break;
                    case "0":
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверный выбор.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
