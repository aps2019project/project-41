import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// write a code for randomizing the decks before setting them into arrays
// game starts with the player[1] giving the command
//may be some problems in setting starting cards

public class Game {
    private static Game onGoingGame;
    private Player[] players;
    private int gameMode;
    private int winner;
    private Map map;
    private int turn;
    private int[] mana;
    private Card selectedCard;
    private Hero[] heros;
    private Item[] items;
    private ArrayList<ArrayList<Card>> cardsInMap;
    private ArrayList<ArrayList<Card>> cardsInHand;
    private ArrayList<ArrayList<Card>> cardsRemainingInDeck;
    private ArrayList<ArrayList<Card>> graveyard;
    private ArrayList<Spell> acteiveSpells;

    public Game(Player[] players, int gameMode, Deck[] decks) {
        this.players = players;
        this.gameMode = gameMode;
        map = new Map();
        turn = 1;
        mana[0] = 3;
        mana[1] = 2; //game starts with player[1]
        cardsInHand = new ArrayList<ArrayList<Card>>(2);
        randomizeDecksOrder(decks);
        setStartingHandsCards(decks);
        setStartingRemainingInDeckCards(decks);
        heros = new Hero[]{decks[0].getHero(), decks[1].getHero()};
        items = new Item[]{decks[0].getItem(), decks[1].getItem()};
    }

    public void nextTurn() {
        this.turn++;
        this.mana[0] = turn / 2 + 1;
        this.mana[1] = turn / 2 + 1;
        selectedCard = null;
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

    public ArrayList<ArrayList<Card>> getCardsInMap() {
        return this.cardsInMap;
    }

    public ArrayList<ArrayList<Card>> getCardsInHand() {
        return this.cardsInHand;
    }

    public ArrayList<ArrayList<Card>> getcardsRemainingInDeck() {
        return this.cardsRemainingInDeck;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public static Game getOnGoingGame() {
        return onGoingGame;
    }

    public Card getSelectedCard() {
        return this.selectedCard;
    }

    public void attack(Card fromCard, Card toCard) {
        // check if Cards are not for one player
        if (!CheckingFunctions.checkIfTheCardsAreForAPlayer(fromCard, toCard, this)) {
            if (CheckingFunctions.checkIfAttackingIsPossible(fromCard, toCard, getDistance(fromCard, toCard))){
                if(fromCard instanceof Hero) {
                    ((Hero) fromCard).attack(toCard);
                    ((Hero) fromCard.

                }
                else if(fromCard instanceof Minion)
                    ((Minion)fromCard).attack(toCard);
                if(toCard instanceof Hero)
                    ((Hero)toCard).counterAttack(toCard);
                else if(toCard instanceof Minion)
                    ((Minion)toCard).counterAttack(toCard);
            }
            else{
                // showing attacking is not possible
            }
        }
        else{
            //showing attacking is not possible
        }
    } // incomplete

    public void insertCard(Card card, int x, int y) {
        if (map.getMapCells()[x][y].getCard() == null) {
            map.getMapCells()[x][y].setCard(card);
            int playerNumber = this.getTurn() % 2;
            cardsInHand.get(playerNumber).remove(card);
            cardsInMap.get(playerNumber).add(card);
            if (!cardsRemainingInDeck.get(playerNumber).isEmpty()) {
                cardsInHand.get(playerNumber).add(cardsRemainingInDeck.get(playerNumber).get(0));
                cardsRemainingInDeck.get(playerNumber).remove(0);
            }
        } else
            System.out.print("there is already a card in that mapcell\n");
    }

    public void selectCard(Card card) {
        this.selectedCard = card;
    }

    public static int watchIfGameEnds(Game game) {
        if (game.getGameMode() == 1)
            return CheckingFunctions.returnPlayerNumberWhoWonTheGameMode1(game);
//        else if (game.getGameMode() == 2)
//            return CheckingFunctions.returnPlayerNumberWhoWonTheGameMode2(game);
//        else if (game.getGameMode() == 3)
//            return CheckingFunctions.returnPlayerNumberWhoWonTheGameMode3(game);
        return -1;
    }//retruns -1 if no one wins the game , return number of player if he wins(0 , 1)

    public void moveCard(Card card, int[] CardLocation, int[] destination) {
        this.map.getMapCells()[CardLocation[0]][CardLocation[1]].setCard(null);
        this.map.getMapCells()[destination[0]][destination[1]].setCard(card);
    }

    private void randomizeDecksOrder(Deck[] decks) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++)
            Collections.swap(decks[0].getCards(), rand.nextInt(20), rand.nextInt(20));
        for (int i = 0; i < 20; i++)
            Collections.swap(decks[1].getCards(), rand.nextInt(20), rand.nextInt(20));
    }

    private void setStartingHandsCards(Deck[] decks) {
        for (int i = 0; i < 5; i++)
            cardsInHand.get(0).add(decks[0].getCards().get(i));
        for (int i = 0; i < 5; i++)
            cardsInHand.get(1).add(decks[1].getCards().get(i));
    }

    private void setStartingRemainingInDeckCards(Deck[] decks) {
        for (int i = 5; i < 20; i++)
            cardsRemainingInDeck.get(0).add(decks[0].getCards().get(i));
        for (int i = 0; i < 5; i++)
            cardsRemainingInDeck.get(1).add(decks[1].getCards().get(i));
    }

    private int getDistance(Card firstCard, Card secondCard) {
        int[] firstCardLocation = new int[2];
        int[] secondCardLocation = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.getMap().getMapCells()[i][j].getCard() == firstCard) {
                    firstCardLocation[0] = i;
                    firstCardLocation[1] = j;
                } else if (this.getMap().getMapCells()[i][j].getCard() == secondCard) {
                    secondCardLocation[0] = i;
                    secondCardLocation[1] = j;
                }
            }
        }
        return ((Math.abs(firstCardLocation[0] - secondCardLocation[0])) + Math.abs(firstCardLocation[1] - secondCardLocation[1]));
    }
}
