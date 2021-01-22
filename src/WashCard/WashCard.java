package WashCard;

public class WashCard {
    private int ID;
    private int balance;

    public WashCard(int ID, int amount) {
        this.ID = ID;
        this.balance = amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public int getID() {
        return ID;
    }

}
