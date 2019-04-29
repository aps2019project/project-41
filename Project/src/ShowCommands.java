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

    }

    public static void showCollectionMenuCommands() {

    }
}
