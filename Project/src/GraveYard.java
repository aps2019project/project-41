import java.util.ArrayList;

public class GraveYard {
    private ArrayList<Card> deadCards = new ArrayList<Card>();

    public ArrayList<Card> getDeadCards() {
        return deadCards;
    }

    public void addCardToGraveYard(Card card){
        if(card != null) {
            deadCards.add(card);
        }
    }
}
