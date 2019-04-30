import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private int id;
    private String name;
    private int price;
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
