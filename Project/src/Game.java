import java.util.ArrayList;

// write a code for randomizing the decks before setting them into arrays
// game starts with the player[1] giving the command
public class Game {
    private static Game onGoingGame;
    private Player[] players;
    private int gameMode;
    private int winner;
    private Map map;
    private int turn;
    private int[] mana;
    private Card selectedCard ;
    private ArrayList<ArrayList<Card>> cardsInMap;
    private ArrayList<ArrayList<Card>> cardsInHand;
    private ArrayList<ArrayList<Card>> cardsInDeck;
    private ArrayList<ArrayList<Card>> graveyard;

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
        selectedCard = null ;
    }

    public int getTurn() {
        return this.turn;
    }

    public Map getMap() {
        return this.map;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public ArrayList<ArrayList<Card>> getcardsInMap() {
        return this.cardsInMap;
    }

    public ArrayList<ArrayList<Card>> getCardsInHand() {
        return this.cardsInHand;
    }

    public ArrayList<ArrayList<Card>> getCardsInDeck() {
        return this.cardsInDeck;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public static Game getOnGoingGame(){
        return onGoingGame;
    }

    public Card getSelectedCard(){
        return this.selectedCard;
    }

    public void attack(Card fromCard, Card toCard) {
        // check if Cards are not for one player
        this.map.attack(fromCard, toCard);
    } // incomplete

    public void insertCard(Card card, int x, int y) {
        if (map.getMapCells()[x][y].getCard() == null) {
            map.getMapCells()[x][y].setCard(card);
            int playerNumber = SearchingFunctions.getNumberOfPlayerHavingCard(card, onGoingGame);
            cardsInHand.get(playerNumber).remove(card);
            cardsInMap.get(playerNumber).add(card);
            if (!cardsInDeck.get(playerNumber).isEmpty()) {
                cardsInHand.get(playerNumber).add(cardsInDeck.get(playerNumber).get(0));
                cardsInDeck.get(playerNumber).remove(0);
            }
        } else
            System.out.print("there is already a card in that mapcell\n");
    }

    public void selectCard(Card card){
        this.selectedCard = card ;
    }

    public static int watchIfGameEnds(Game game){
        if(game.getGameMode() == 1)
            return CheckingFunctions.returnPlayerNumberWhoWonTheGameMode1(game);
        else if(game.getGameMode() == 2)
            return CheckingFunctions.returnPlayerNumberWhoWonTheGameMode2(game);
        else if(game.getGameMode() == 3)
            return CheckingFunctions.returnPlayerNumberWhoWonTheGameMode3(game);
        return -1 ;
    }//retruns -1 if no one wins the game , return number of player if he wins(0 , 1)

}
