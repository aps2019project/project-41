import java.util.ArrayList;

public class Card {
    ArrayList<Card> cards = new ArrayList<>();
    private final int id;
    private final String name;
    private final int price;
    public Card(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}
