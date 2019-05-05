public class SearchingFunctions {
    public static String searchForCardOrItemInCollectionAndReturnID(String name, Collection playerCollection) {
        for(Card card : playerCollection.getCards()){
            if(card.getName().equalsIgnoreCase(name))
                return card.getId();
        }
        for(Item item : playerCollection.getItems()){
            if(item.getName().equals(name))
                return item.getID();
        }
        return "";
    }

    public static Card findCardInAllCards(String cardName) {
        for (Card card : Card.getCards()) {
            if (card.getName().equalsIgnoreCase(cardName))
                return card;
        }
        return null;
    }

    public static int searchForCardOrItemInShopAndReturnID(String name) {

        return 0;
    }

    public static Player findPlayer(String userName) {
        for (Player player : Player.getPlayers())
            if (player.getUserName().equals(userName))
                return player;
        return null;
    }


    public static Deck findPlayerDeck(String deckName, Player player) {
        for(Deck deck : player.getDecks()){
            if(deck.getName().equals(deckName))
                return deck;
        }
        return null;
    }

    public static int getNumberOfPlayerHavingCard(Card card, Game game) {
        for (Card card1 : game.getCardsInDeck().get(0)) {
            if (card1 == card)
                return 0;
        }
        for (Card card1 : game.getCardsInDeck().get(1)) {
            if (card1 == card)
                return 1;
        }
        return 2;
    } // just watches for the cards in map

    public static int[] getCardLocation(Game game, Card card) {
        MapCell[][] mapcells = game.getMap().getMapCells();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (mapcells[i][j].getCard() == card)
                    return new int[]{j, i};
            }
        }
        return new int[]{0};
    }

    public static Card findCardInGame(String cardID, Game game) {
        for (Card card : game.getcardsInMap().get(0)) {
            if (card.getId().equalsIgnoreCase(cardID))
                return card;
        }
        for (Card card : game.getcardsInMap().get(1)) {
            if (card.getId().equalsIgnoreCase(cardID))
                return card;
        }
        for (Card card : game.getCardsInHand().get(0)) {
            if (card.getId().equalsIgnoreCase(cardID))
                return card;
        }
        for (Card card : game.getCardsInHand().get(1)) {
            if (card.getId().equalsIgnoreCase(cardID))
                return card;
        }
        return null;
    } // doesnt consider the cards remaining in decks

    public static Card findCardInHand(String cardName, Game game, int playerNumber) {
        for (Card card : game.getCardsInHand().get(playerNumber)) {
            if (card.getName().equalsIgnoreCase(cardName))
                return card;
        }
        return null;
    }

    public static Card findCardInCollection(String cardName , Player player){
        for(Card card : player.getCollection().getCards()){
            if(card.getName().equals(cardName))
                return card;
        }
        return null;
    }

    public static Item findItemInCollection(String itemName , Player player){
        for(Item item : player.getCollection().getItems()){
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }
}
