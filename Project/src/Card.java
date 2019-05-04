import java.util.ArrayList;

public abstract class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private final int id;
    private final String name;
    private final int price;
    private Player player;

    public Card(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public static ArrayList<Card> getCards() {
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

    public Player getPlayer() { return player; }

    public String getCardType() { return "";}

}
