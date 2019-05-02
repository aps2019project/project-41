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

    }

    public static void showShopMenuCommands() {
        System.out.printf("ShopMenu Commands : \nexit\nshow collection\nsearch [item name | card name]\n" +
                "search collection [item name | card name]\nbuy [item name | card name]\n" +
                "sell [item name | card name]\nshow\nhelp\n");
    }

    public static void showCollectionMenuCommands() {

    }

    public static void showAllCardsInShop(){

    }
}
