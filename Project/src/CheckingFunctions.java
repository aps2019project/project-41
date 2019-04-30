import java.util.regex.Pattern;

//checkifsavecommand not complete
//searchItemOrCardCommand just searches the first name
// not checking items in buying card in shop
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
                Player player = SearchingFunctions.findPlayer(splitedCommand[1]);
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
    // shopMenu Commands
    public static boolean checkIfShowCollectionCommandAndProccessIt(String command) {
        if (Pattern.compile("show\\s+collection", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showCollection(Player.getLogedInPlayer());
            return true;
        }
        return false;
    }

    public static boolean checkIfSearchItemOrCardInShopCommandAndProccessIt(String command) {
        if (Pattern.compile("search\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String splitedCommand[] = command.split("\\s+");
            int id = SearchingFunctions.searchForCardOrItemInShopAndReturnID(splitedCommand[1]);
            if (id == 0)
                System.out.print("no card or item with this name\n");
            else
                System.out.printf("ID : %d", id);
            return true;
        }
        return false;
    }

    public static boolean checkIfSearchItemOrCardInCollectionCommandAndProccessIt(String command) {
        if (Pattern.compile("search\\s+collection\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            int id = SearchingFunctions.searchForCardOrItemInCollectionAndReturnID(command.split("\\s+")[1], Player.getLogedInPlayer().getCollection());
            if (id == 0)
                System.out.print("no card or item with this name\n");
            else
                System.out.printf("%d\n", id);
            return true;
        }
        return false;
    }

    public static boolean checkIfBuyCardCommandAndProccessIt(String command) {
        if (Pattern.compile("buy\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String cardName = command.split("\\s+")[1];
            if (checkIfCardExistsInShop(cardName)) {
                Card card = SearchingFunctions.findCardInAllCards(cardName);
                if (Player.getLogedInPlayer().getDeriks() < card.getPrice())
                    System.out.print("not enough deriks\n");
                else {
                    if (true)/*checking for three item in player collection*/ {
                        Player.getLogedInPlayer().buyCard(card);
                        System.out.print("you bought the card\n");
                    } else
                        System.out.print("you already have three items in your collection\n");
                }
            } else
                System.out.print("no card with this name\n");
            return true ;
        }
        return false;
    }

    public static boolean checkIfSellCardCommandAndProccessIt(String command) {
        if(Pattern.compile("sell\\s+\\w+" , Pattern.CASE_INSENSITIVE).matcher(command).matches()){
            String cardName = command.split("\\s+")[1] ;
            if(checkIfPlayerHasTheCard(cardName)){
                Player.getLogedInPlayer().sellCard(SearchingFunctions.findCardInAllCards(cardName));
                System.out.print("you sold the card\n");
            }
            else
                System.out.print("you don't have any card with this name\n");
            return true ;
        }
        return false ;
    }

    public static boolean checkIfShowCommandAndProccessIt(String command){
        if(command.equalsIgnoreCase("show")){
            ShowCommands.showAllCardsInShop();
            return true ;
        }
        return false ;
    }
    //
    // collection menu commands

    public static boolean checkIfCreateDeckCommandAndProccessIt(String command){
        if(Pattern.compile("create\\s+deck\\w+" , Pattern.CASE_INSENSITIVE).matcher(command).matches()){
            String deckName = command.split("\\s+")[2] ;
            if(checkIfPlayerHasTheDeck(deckName , Player.getLogedInPlayer()))
                System.out.print("you already have a deck with this name\n");
            else
                Player.getLogedInPlayer().addDeck(new Deck()); // should add deck's name
            return true ;
        }
        return false ;
    }


    public static boolean checkIfUserNameExists(String userName) {
        for (Player player : Player.getPlayers()) {
            if (player.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    public static boolean checkIfCardExistsInShop(String cardName) {

        return false;
    }

    public static boolean checkIfPlayerHasTheCard(String cardName){

        return false ;
    }

    public static boolean checkIfPlayerHasTheDeck(String deckName , Player player){

    }
}
