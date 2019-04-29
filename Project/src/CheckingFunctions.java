import java.util.regex.Pattern;

//checkifsavecommand not complete
//searchItemOrCardCommand just searches the first name

public class CheckingFunctions {
    // login menu commands
    public static boolean checkIfCreateAccountCommandAndProccessIt(String command) {
        if (Pattern.compile("create\\s+account\\s+\\w+]", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String splitedCommand[] = command.split("\\s+");
            if (checkIfUserNameExists(splitedCommand[2]))
                System.out.print("username already exists\n");
            else {
                String password = Scanners.input.nextLine().trim();
                new Player(splitedCommand[0], splitedCommand[1], 0);
            }
            return true;
        }
        return false;
    }

    public static boolean checkIfLoginCommandAndProccessIt(String command) { // returns true if logging into account was successful
        if (Pattern.compile("login\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String splitedCommand[] = command.split("\\s+");
            if (checkIfUserNameExists(splitedCommand[1])) {
                String password = Scanners.input.nextLine().trim();
                Player player = findPlayer(splitedCommand[1]);
                if (player.getPassword().equals(password)) {
                    Player.logIn(player);
                    return true;
                } else
                    System.out.print("wrong password\n");
            } else
                System.out.print("username not found\n");
        }
        return false;
    }

    public static boolean checkIfShowLeaderBoardCommandAndProccessIt(String command) {
        if (Pattern.compile("show\\s+leaderboard", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            SortingFunctions.sortPlayersByWin();
            ShowCommands.showLeaderBoard();
            return true;
        }
        return false;
    }

    public static boolean checkIfSaveCommandAndProccessIt(String command) {
        if (command.equalsIgnoreCase("save")) {

            return true;
        }
        return false;
    }

    public static boolean checkIfLogOutCommandAndProccessIt(String commnad) {
        if (commnad.equalsIgnoreCase("logout")) {
            Player.logOut();
            return true;
        }
        return false;
    }

    //
    // shopMenu Command
    public static boolean checkIfShowCollectionCommandAndProccessIt(String command) {
        if (Pattern.compile("show\\s+collection", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showCollection(Player.getLogedInPlayer());
            return true;
        }
        return false;
    }

    public static boolean checkIfSearchItemOrCardCommandAndProccessIt(String command) {
        if (Pattern.compile("search\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String splitedCommand[] = command.split("\\s+");
            int id = SearchingFunctions.searchForCardOrItemInCollectionAndReturnID(splitedCommand[1], Player.getLogedInPlayer().getCollection());
            if (id == 0)
                System.out.print("no card or item with this name\n");
            else
                System.out.printf("ID : %d", id);
            return true;
        }
        return false;
    }


    public static boolean checkIfUserNameExists(String userName) {
        for (Player player : Player.getPlayers()) {
            if (player.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    public static Player findPlayer(String userName) {
        for (Player player : Player.getPlayers())
            if (player.getUserName().equals(userName))
                return player;
        return null;

    }
}
