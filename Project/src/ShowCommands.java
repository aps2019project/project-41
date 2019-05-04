public class ShowCommands {
    public static void showLeaderBoard() {
        int i;
        for (i = 0; i < Player.getPlayers().size(); i++) {
            Player player = Player.getPlayers().get(i);
            System.out.printf("%d - UserName : %s-Wins : %d", i + 1, player.getUserName(), player.getWins());
        }
    }

    public static void showCollection(Player player){

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

    public static void showPlayerDecks(Player player){
        for(Deck deck : player.getDecks())
            showDeck(deck);
    }
    public static void showDeck(Deck deck){

    }

    public static void showAllCardsInShop(){

    }
}
