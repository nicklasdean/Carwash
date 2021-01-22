package controller;

import UI.Menu;
import WashCard.WashCard;
import WashCard.WashCardList;
import statistics.Counter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Terminal {
    private WashCardList cards;
    private Menu ui = new Menu();
    private Counter statistics = new Counter();
    private static final int ECONOMY_PRICE = 50;
    private static final int STANDARD_PRICE = 80;
    private static final int DELUXE_PRICE = 120;
    private static final double EARLY_BIRD_PERCENTAGE = 0.2;
    private static final double EARLY_BIRD_END = 14; // Early bird ends at 14.00 PM

    public Terminal(WashCardList cards) {
        this.cards = cards;
    }

    public void run() {
        int choice = 0;
        while (true) {
            ui.printMenu();
            choice = ui.getMenuOption();

            switch (choice) {
                case 1:
                    buyWash();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    getStatistics();
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    public void buyWash() {
        int ID = ui.getID("Insert card (enter card ID): ");
        WashCard washcard = cards.findCardByID(ID);

        //Error checking
        if (washcard == null) {
            // Right now just returning to main menu
            return;
        }

        String washtype = ui.chooseWashType();
        withdrawMoneyOnCard(washtype, washcard);

        statistics.registerWash(washtype);
    }

    private void withdrawMoneyOnCard(String washtype, WashCard washCard) {
        int price = calculatePrice(washtype);
        washCard.withdraw(price);
    }

    private int calculatePrice(String washtype) {
        int standardPrice = findStandardPrice(washtype);
        return  (int) (isEarlyBird() ? standardPrice - (standardPrice * EARLY_BIRD_PERCENTAGE) : standardPrice);
    }

    private int findStandardPrice(String washtype) {
        switch(washtype) {
            case "ECONOMY":  return ECONOMY_PRICE;
            case "STANDARD": return STANDARD_PRICE;
            case "DELUXE":   return DELUXE_PRICE;
            default:        return 0;
        }
    }

    private boolean isEarlyBird() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek day = now.getDayOfWeek();
        int dayAsIntValue = day.getValue(); //Monday 1 - Friday 5
        int hour = now.getHour();
        return (dayAsIntValue >= 1 && dayAsIntValue <= 5) && hour < EARLY_BIRD_END;
    }

    public void checkBalance() {
        int ID = ui.getID("Insert card (enter card ID): ");
        WashCard washCard = cards.findCardByID(ID);
        System.out.println("Balance is " + washCard.getBalance());
    }

    public void getStatistics() {
        System.out.println(statistics);
    }
}
