import java.util.ArrayList;

public class Deck {
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Hero hero;
    private Item item;

    public Deck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Hero getHero() {
        return hero;
    }

    public Item getItem() {
        return item;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void removeHero() {
        this.hero = null;
    }

    public void removeItem() {
        this.item = null;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
