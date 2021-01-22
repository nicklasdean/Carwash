package WashCard;

import java.util.ArrayList;

public class WashCardList {
    ArrayList<WashCard> washCards = new ArrayList();
    private static int IDGenerator;

    public void addCard(int amount) {
        WashCard newWashCard = new WashCard(++IDGenerator, amount);
        washCards.add(newWashCard);
    }

    public WashCard findCardByID(int cardID) {
        for (int i = 0; i < washCards.size(); i++) {
            if (washCards.get(i).getID() == cardID) {
                return washCards.get(i);
            }
        }
        return null;
    }

}
