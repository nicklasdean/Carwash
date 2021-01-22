package UI;

import java.util.Scanner;

public class Menu {
    private Scanner scan = new Scanner(System.in);

    public void printMenu() {
        System.out.println("Main menu - Exit with 9");
        System.out.println("1. Buy wash");
        System.out.println("2. Check balance");
        System.out.println("3. Statistics");
        System.out.print("Enter choice: ");
    }

    public int getMenuOption() {
        int choice = 0;
        while (!scan.hasNextInt()) {
            System.out.println("\nYou must enter number!");
            System.out.print("Enter choice: ");
            scan.nextLine();
        }
        choice = scan.nextInt();
        return choice;
    }

    public int getID(String message) {
        System.out.print(message);
        int ID = scan.nextInt();
        return ID;
    }

    public int getAmount() {
        System.out.print("Enter amount:  ");
        int amount = scan.nextInt();
        return amount;
    }

    public String chooseWashType() {
        System.out.print("What type do you want to buy? (Economy, Standard, DeLuxe) ");
        String washType = scan.next().toUpperCase();

        if (washType.equals("ECONOMY") || washType.equals("E")) {
            return "ECONOMY";
        }
        else if (washType.equals("STANDARD") || washType.equals("S")) {
            return "STANDARD";
        }
        else if (washType.equals("DELUXE") || washType.equals("D")) {
            return "DELUXE";
        }
        return null;
    }
}
