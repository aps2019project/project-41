public class SearchingFunctions {
    public static int searchForCardOrItemInCollectionAndReturnID(String name, Collection playerCollection) {

        return 0 ;
    }

    public static int searchForCardOrItemInShopAndReturnID(String name){

        return 0 ;
    }

    public static Player findPlayer(String userName) {
        for (Player player : Player.getPlayers())
            if (player.getUserName().equals(userName))
                return player;
        return null;
    }

    public static Card findCardInAllCards(String cardName){
        for(Card card : Card.getCards()){
            if(card.getName().equalsIgnoreCase(cardName))
                return card ;
        }
        return null ;
    }

    public static Deck findPlayerDeck(String deckName , Player player){

    }
}
