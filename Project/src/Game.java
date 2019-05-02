// write a code for randomizing the decks before setting them into arrays
// game starts with the player[1] giving the command
public class Game {
    private Player[] players;
    private int gameMode;
    private int winner;
    private Map map;
    private int turn;
    private int[] mana;
    private Card[][] cardsInMap;
    private Card[][] cardsInHand;
    private Card[][] cardsInDeck;
    private Card[][] graveyard;

    public Game(Player[] players, int gameMode, Deck[] decks) {
        this.players = players;
        this.gameMode = gameMode;
        map = new Map();
        turn = 1;
        mana[0] = 3;
        mana[1] = 2;
        // setting cards into arrays commands
    }

    public void nextTurn() {
        this.turn++;
        this.mana[0] = turn / 2 + 1;
        this.mana[1] = turn / 2 + 1;
    }

    public int getTurn(){
        return this.turn;
    }

    public Map getMap(){
        return this.map ;
    }

    public Player[] getPlayers(){
        return this.players;
    }
    
    public Card[][] getcardsInMap(){
        return this.cardsInMap ;
    }

    public Card[][] getCardsInHand(){
        return this.cardsInHand ;
    }

    public Card[][] getCardsInDeck(){
        return this.cardsInDeck ;
    }

    public void attack(Card fromCard , Card toCard){
        // check if Cards are not for one player
        this.map.attack(fromCard , toCard);
    } // incomplete

    public void insertCard(Card card , int x , int y){
        if(map.getMapCells()[x][y].getCard() == null){
            map.getMapCells()[x][y].setCard(card);
        }
        else
            System.out.print("there is already a card in that mapcell\n");
    }
}
