import java.util.ArrayList;

public class Card {
<<<<<<< HEAD
    ArrayList<Card> cards = new ArrayList<>();
    private final int id;
    private final String name;
    private final int price;
    public Card(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
=======
    private static ArrayList<Card> cards = new ArrayList<>();
    private int id;
    private String name;
    private int price;


>>>>>>> 71be82717f4be680b0e1fdf330cf3dbfefc4e415
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
