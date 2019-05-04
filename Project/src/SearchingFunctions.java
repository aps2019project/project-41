public class SearchingFunctions {
    public static int searchForCardOrItemInCollectionAndReturnID(String name, Collection playerCollection) {

        return 0;
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
    return null;
    }

    public static int getNumberOfPlayerHavingCard(Card card, Game game) {
        for (Card card1 : game.getCardsInDeck()[0]) {
            if (card1 == card)
                return 0;
        }
        for (Card card1 : game.getCardsInDeck()[1]) {
            if (card1 == card)
                return 1;
        }
        return 2;
    } // just watches for the cards in map

    public static String getCardLocation(Game game, Card card) {
        MapCell[][] mapcells = game.getMap().getMapCells();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (mapcells[i][j].getCard() == card)
                    return "(" + Integer.toString(j) + "," + Integer.toString(i) + ")";
            }
        }
        return "" ;
    }

    public static Card findCardInGame(String cardID , Game game){
        for(Card card : game.getcardsInMap().get(0)){
            if(card.getId().equalsIgnoreCase(cardID))
                return card ;
        }
        for(Card card : game.getcardsInMap().get(1)){
            if(card.getId().equalsIgnoreCase(cardID))
                return card ;
        }
        for(Card card : game.getCardsInHand().get(0)){
            if(card.getId().equalsIgnoreCase(cardID))
                return card ;
        }
        for(Card card : game.getCardsInHand().get(1)){
            if(card.getId().equalsIgnoreCase(cardID))
                return card ;
        }
        return null;
    } // doesnt consider the cards remaining in decks
}
