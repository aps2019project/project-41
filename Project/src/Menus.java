import java.util.regex.Pattern;

// watch starting deriks of the player when creating it in creat account command
// saving functions in collection menu are not complete
public class Menus {
    public static int mainMenu() {
        String command;
        while (true) {
            command = Scanners.input.nextLine().trim();
            if (command.equalsIgnoreCase("exit"))
                return -1;
            else if (command.equalsIgnoreCase("help"))
                ShowCommands.showMainMenuCommands();
            else if (Pattern.compile("enter\\s+shop", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
                ShowCommands.showShopMenuCommands();
                shopMenu();
            } else if (Pattern.compile("enter\\s+collection", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
                ShowCommands.showCollectionMenuCommands();
                collectionMenu();
            } else if (Pattern.compile("enter\\s+battle", Pattern.CASE_INSENSITIVE).matcher(command).matches())
                return 1;
        }
    }

    public static void shopMenu() {
        String command;
        while (true) {
            command = Scanners.input.nextLine().trim();
            if (command.equalsIgnoreCase("exit"))
                return;
            else if (command.equalsIgnoreCase("help"))
                ShowCommands.showShopMenuCommands();
            else if (CheckingFunctions.checkIfShowCollectionCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfSearchItemOrCardInShopCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfSearchItemOrCardInCollectionCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfBuyCardCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfSellCardCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfShowCommandAndProccessIt(command)) ;
        }
    }

    public static void collectionMenu() {
        String command ;
        while(true){
            command = Scanners.input.nextLine().trim() ;
            if(command.equalsIgnoreCase("exit"))
                return ;
            else if (command.equalsIgnoreCase("show"))
                ShowCommands.showCollection(Player.getLogedInPlayer());
            else if (command.equalsIgnoreCase("help"))
                ShowCommands.showCollectionMenuCommands();
            else if (command.equalsIgnoreCase("save")) ;
            else if (CheckingFunctions.checkIfSearchItemOrCardInCollectionCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfCreateDeckCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfDeleteDeckCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfAddCardToDeckCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfRemoveCardFromDeckCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfValidateDeckCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfSelectDeckCommandAndProccessIt(command)) ;
            else if (Pattern.compile("show\\s+all\\s+decks",Pattern.CASE_INSENSITIVE).matcher(command).matches())
                ShowCommands.showPlayerDecks(Player.getLogedInPlayer());
            else if (Pattern.compile("show\\s+deck\\s+\\w+",Pattern.CASE_INSENSITIVE).matcher(command).matches())
            {
                if(CheckingFunctions.checkIfPlayerHasTheDeck(command.split("\\s+")[2] , Player.getLogedInPlayer()))
                    ShowCommands.showDeck(SearchingFunctions.findPlayerDeck(command.split("\\s+")[2] , Player.getLogedInPlayer()));
                else
                    System.out.print("you have no deck with this name\n");
            }
            else if (command.equalsIgnoreCase("save")) ;
            else if (CheckingFunctions.checkIfSearchItemOrCardInCollectionCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfCreateDeckCommandAndProccessIt(command)) ;

        }
    }

    public static int loginMenu() {
        String command;
        while (true) {
            command = Scanners.input.nextLine().trim();
            if (command.equalsIgnoreCase("exit"))
                return -1;
            else if (CheckingFunctions.checkIfCreateAccountCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfLoginCommandAndProccessIt(command)) {
                ShowCommands.showMainMenuCommands();
                return 1;
            } else if (CheckingFunctions.checkIfShowLeaderBoardCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfSaveCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfLogOutCommandAndProccessIt(command)) {
                if (Menus.loginMenu() == -1)
                    return -1;
            } else if (command.equalsIgnoreCase("help"))
                ShowCommands.showLoginMenuCommands();
        }
    }
}
