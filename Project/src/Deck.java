import java.util.ArrayList;

public class Deck {
    private String name;
    private Card[] cards = new Card[20];
    private Hero hero;
    private Item item;

    public Deck(String name,Card[] cards, Hero hero, Item item) {
        this.name = name;
        this.cards = cards;
        this.hero = hero;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

    public Hero getHero() {
        return hero;
    }

    public Item getItem() {
        return item;
    }
}
