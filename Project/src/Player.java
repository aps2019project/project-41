import java.util.ArrayList;

public class Player {
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Player logedInPlayer;
    private final String username;
    private final String password;
    private int deriks;
    private ArrayList<Game> games;
    private Collection collection;
    private ArrayList<Deck> decks;

    public Player(String name, String password, int deriks) {
        this.username = name;
        this.password = password;
        this.deriks = deriks;
        Player.players.add(this);
    }

    public static void creatAccound(String name, String password, int deriks) {
        new Player(name, password, deriks);
    }

    public static ArrayList<Player> getPlayers() {
        return Player.players;
    }

    public static void logOut() {
        logedInPlayer = null;
    }

    public static void logIn(Player player) {
        logedInPlayer = player;
    }

    public String getUserName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getDeriks() {
        return this.deriks;
    }

    public Player getLogedInPlayer() {
        return Player.logedInPlayer;
    }

    public Collection getCollection() {
        return this.collection;
    }

    public ArrayList<Desk> getDecks() {
        return this.decks;
    }

    public void save() {

    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    public void buyCard(Card card) {
        this.deriks -= card.getPrice();
        this.collection.cards.add(card);
    }

    public void sellCard(Card card) {
        this.deriks += card.getPrice();
        this.collection.cards.remove(card);
    }

}
