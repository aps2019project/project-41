import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public void removeItem(Item item){
        items.remove(item);
    }
}
