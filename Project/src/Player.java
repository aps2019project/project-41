import java.util.ArrayList;

// when removing cards and items from collection or deck , we remove it just once while it can be repeated
public class Player {
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Player logedInPlayer;
    private final String username;
    private final String password;
    private int deriks;
    private int wins;
    private Deck mainDeck;
    private ArrayList<Game> games;
    private Collection collection;
    private ArrayList<Deck> decks;

    public Player(String name, String password, int deriks) {
        this.username = name;
        this.password = password;
        this.deriks = deriks;
        Player.players.add(this);
        wins = 0;
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

    public int getWins() {
        return this.wins;
    }

    public Deck getMainDeck() {
        return this.mainDeck;
    }

    public void setMainDeck(Deck deck) {
        this.mainDeck = deck;
    }

    public void setWins(int number) {
        this.wins = number;
    }

    public static Player getLogedInPlayer() {
        return Player.logedInPlayer;
    }

    public Collection getCollection() {
        return this.collection;
    }

    public ArrayList<Deck> getDecks() {
        return this.decks;
    }

    public void save() {

    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    public void deleteDeck(Deck deck){
        this.decks.remove(deck) ;
    }

    public void buyCard(Card card) {
        this.deriks -= card.getPrice();
        this.collection.addCard(card);
    }

    public void buyItem(Item item){
        this.deriks -= item.getPrice();

    }

    public void sellCard(Card card){
        if(card instanceof Minion)
            sellMinion((Minion)card);
        else if (card instanceof Hero)
            sellHero((Hero)card);
    }

    private void sellMinion(Minion minion){
        this.deriks += minion.getPrice();
        this.collection.removeCard(minion);
        for(Deck deck : this.getDecks()){
            deck.removeCard(minion);
        }
    }

    private void sellHero(Hero hero) {
        this.deriks += hero.getPrice();
        this.collection.removeCard(hero);
        for(Deck deck : this.getDecks()){
            if(deck.getHero() == hero)
                deck.removeHero();
        }
    }

    public void sellItem(Item item){
        this.deriks += item.getPrice();
        this.collection.removeItem(item);
        for(Deck deck : this.getDecks()){
            if(deck.getItem() == item)
                deck.removeItem();
        }
    }
}
