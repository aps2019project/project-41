import java.util.ArrayList;
//not showing the special power in showcommand in collection

public class ShowCommands {
    public static void showLeaderBoard() {
        int i;
        for (i = 0; i < Player.getPlayers().size(); i++) {
            Player player = Player.getPlayers().get(i);
            System.out.printf("%d - UserName : %s-Wins : %d", i + 1, player.getUserName(), player.getWins());
        }
    }

    public static void showCollection(Player player) {
        showAllHeroes(player.getCollection().getCards());
        showAllMinions(player.getCollection().getCards());
        showAllItems(player.getCollection().getItems());
    }

    public static void showLoginMenuCommands() {
        System.out.print("loginMenuCommands : \n" +
                "create account\nlogin\nshow leaderboard\nsave\nlogout\nsave\nhelp");
    }

    public static void showMainMenuCommands() {
        System.out.print("MainMenu Commands : \nexit\nenter Collection\nenter Shop\n" +
                "enter battle\nhelp\n");
    }

    public static void showShopMenuCommands() {
        System.out.printf("ShopMenu Commands : \nexit\nshow collection\nsearch [item name | card name]\n" +
                "search collection [item name | card name]\nbuy [item name | card name]\n" +
                "sell [item name | card name]\nshow\nhelp\n");
    }

    public static void showCollectionMenuCommands() {
        System.out.print("CollectionMenu Commands : \nexit\nshow\nsearch [card name | item name]\n" +
                "save\ncreate deck [deck name]\ndelete deck [deck name]\nadd [card id | card id | hero id] to deck [deck name]\n" +
                "remove [card id | card id | hero id] from deck [deck name]\nvalidate deck [deck name]\n" +
                "select deck [deck name]\nshow all decks\nshow deck [deck name]\nhelp\n");
    }

    public static void showAllCardsAndItemsInShop(){
        showAllHeroes(Card.getCards()) ;
        showAllMinions(Card.getCards()) ;
        showAllItems(Item.getItems()) ;
    }

    private static void showAllHeroes(ArrayList<Card> cards){
        int i = 1 ;
        for(Card card : cards){
            if(card instanceof Hero){
                System.out.printf("%d : Name : %s - AP : %d - HP : %d - class : %s - special power : %s - " +
                                "sell cost : %d" , i++ , card.getName() , ((Hero) card).getAp() , ((Hero) card).getHp() ,
                        card.getCardType() , "not considered now" , card.getPrice());
            }
        }
    }

    private static void showAllMinions(ArrayList<Card> cards){
        int i = 1 ;
        for(Card card : cards){
            if(card instanceof Minion){
                System.out.printf("%d : Name : %s - AP : %d - HP : %d - class : %s - special power : %s - " +
                                "sell cost : %d" , i++ , card.getName() , ((Minion) card).getAp() , ((Minion) card).getHp() ,
                        card.getCardType() , "not considered now" , card.getPrice());
            }
        }
    }

    private static void showAllItems(ArrayList<Item> items){
        int i = 1 ;
        for(Item item : items){
            System.out.printf("%d : Name : %s - Desc : %s - Sell Cost : %d" ,
                    i++ , item.getName() , "no description yet" , item.getPrice());
        }
    }

    public static void showPlayerDecks(Player player){
        for(Deck deck : player.getDecks())
            showDeck(deck);
    }

    public static void showDeck(Deck deck) {

    }

    public static void showGameInfo(Game game) {
        if (game.getGameMode() == 1)
            showHeroesHealth(game);
        else if (game.getGameMode() == 2)
            showFlagLocation(game.getMap().getMapCells());
        else if (game.getGameMode() == 3)
            showCardsHavingFlag(game);

    }

    public static void showHeroesHealth(Game game) {
        Map map = game.getMap();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (map.getMapCells()[i][j].getCard() instanceof Hero)
                    System.out.printf("%s health : %d", map.getMapCells()[i][j].getCard().getName(), ((Hero) map.getMapCells()[i][j].getCard()).getHp());
            }
        }
    }

    public static void showFlagLocation(MapCell[][] mapCells) {

    }

    public static void showCardsHavingFlag(Game game) {

    }

    public static void showPlayerMinions(Game game, int playerNumber) {
        for (Card card : game.getcardsInMap().get(playerNumber)) {
            if (card instanceof Minion)
            {
                int[] location = SearchingFunctions.getCardLocation(game, card) ;
                System.out.printf("%s : %s , Health : %d , Location : %s , Power : %d\n",
                        card.getId(), card.getName(), ((Minion) card).getHp(),
                        "("+Integer.toString(location[0])+","+Integer.toString(location[1])+")"
                        , ((Minion) card).getAp());
            }

        }
    }

    public static void showCardInfo(String cardID, Game game) {

    }

    public static void showHand(Game game , int playerNumber){
        for(Card card : game.getCardsInHand().get(playerNumber)){
            System.out.printf("%s\n" , card.getName());
        }
        if(!game.getCardsInDeck().isEmpty())
            System.out.printf("%s\n" , game.getcardsInMap().get(playerNumber).get(0));
    }
}
