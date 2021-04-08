import washcard.WashCardList;
import controller.Terminal;

public class CarwashApplication {

    public static void main(String[] args) {
        //Create test data: a list of wash card objects to be used for testing purpose
        WashCardList cards = new WashCardList();
        cards.addCard(200);
        cards.addCard(500);
        cards.addCard(1000);

        // Turn on machine!
        Terminal machine = new Terminal(cards);
        machine.run();
    }
}
