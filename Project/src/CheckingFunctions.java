import java.util.regex.Pattern;

//checkifsavecommand not complete
//searchItemOrCardCommand just searches the first name
// not checking items in buying card in shop
// remember to make cardID a String
//not checking if deckName is invalid in addCardToDeck command in collection
//when adding card to deck in collection , how should we know the id of the cards(used name instead)
//not generating any card id so i used card name instead in some cases --- > watch out shop and collection commands
public class CheckingFunctions {
    // login menu commands
    public static boolean checkIfCreateAccountCommandAndProcessIt(String command) {
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

    public static boolean checkIfLoginCommandAndProcessIt(String command) { // returns true if logging into account was successful
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

    public static boolean checkIfShowLeaderBoardCommandAndProcessIt(String command) {
        if (Pattern.compile("show\\s+leaderboard", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            SortingFunctions.sortPlayersByWin();
            ShowCommands.showLeaderBoard();
            return true;
        }
        return false;
    }

    public static boolean checkIfSaveCommandAndProcessIt(String command) {
        if (command.equalsIgnoreCase("save")) {

            return true;
        }
        return false;
    }

    public static boolean checkIfLogOutCommandAndProcessIt(String commnad) {
        if (commnad.equalsIgnoreCase("logout")) {
            Player.logOut();
            return true;
        }
        return false;
    }

    //
    // shopMenu Commands
    public static boolean checkIfShowCollectionCommandAndProcessIt(String command) {
        if (Pattern.compile("show\\s+collection", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showCollection(Player.getLogedInPlayer());
            return true;
        }
        return false;
    }

    public static boolean checkIfSearchItemOrCardInShopCommandAndProcessIt(String command) {
        if (Pattern.compile("search\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String splitedCommand[] = command.split("\\s+");
            String id = SearchingFunctions.searchForCardOrItemInShopAndReturnID(splitedCommand[1]);
            if (id.equalsIgnoreCase(""))
                System.out.print("no card or item with this name\n");
            else
                System.out.printf("ID : %d", id);
            return true;
        }
        return false;
    }

    public static boolean checkIfSearchItemOrCardInCollectionCommandAndProcessIt(String command) {
        if (Pattern.compile("search\\s+collection\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String id = SearchingFunctions.searchForCardOrItemInCollectionAndReturnID(command.split("\\s+")[1], Player.getLogedInPlayer().getCollection());
            if (id.equals(""))
                System.out.print("no card or item with this name\n");
            else
                System.out.printf("%s\n", id);
            return true;
        }
        return false;
    }

    public static boolean checkIfBuyCardCommandAndProcessIt(String command) {
        if (Pattern.compile("buy\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String cardOrItemName = command.split("\\s+")[1];
            if (checkIfCardExistsInShop(cardOrItemName)) {
                Card card = SearchingFunctions.findCardInAllCards(cardOrItemName);
                if (Player.getLogedInPlayer().getDeriks() < card.getPrice())
                    System.out.print("not enough deriks\n");
                else {
                        Player.getLogedInPlayer().buyCard(card);
                        System.out.print("you bought the card\n");
                }
            } else if (checkIfItemExistsInShop(cardOrItemName)) {
                Item item = SearchingFunctions.findItemInAllItems(cardOrItemName);
                if(Player.getLogedInPlayer().getDeriks() < item.getPrice())
                    System.out.print("not enough deriks\n");
                else{
                    if(Player.getLogedInPlayer().getCollection().getItems().size() < 3){
                        Player.getLogedInPlayer().buyItem(item);
                        System.out.print("you bought the item\n");
                    }
                    else
                        System.out.print("you already have 3 items in your collection\n");
                }
            } else
                System.out.print("there is no card or item with this name in the shop\n");
            return true;
        }
        return false;
    }

    public static boolean checkIfSellCardCommandAndProcessIt(String command) {
        if (Pattern.compile("sell\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String cardOrItemName = command.split("\\s+")[1];
            Card card = SearchingFunctions.findCardInCollection(cardOrItemName, Player.getLogedInPlayer());
            if (card != null) {
                Player.getLogedInPlayer().sellCard(card);
                System.out.print("you sold the card\n");
            } else {
                Item item = SearchingFunctions.findItemInCollection(cardOrItemName, Player.getLogedInPlayer());
                if (item != null) {
                    Player.getLogedInPlayer().sellItem(item);
                    System.out.print("you sold the item\n");
                } else
                    System.out.print("you don't have any card with this name\n");
            }
            return true;
        }
        return false;
    }

    public static boolean checkIfShopShowCommandAndProcessIt(String command) {
        if (command.equalsIgnoreCase("show")) {
            ShowCommands.showAllCardsAndItemsInShop();
            return true;
        }
        return false;
    }

    //
    // collection menu commands

    public static boolean checkIfCreateDeckCommandAndProcessIt(String command) {
        if (Pattern.compile("create\\s+deck\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String deckName = command.split("\\s+")[2];
            if (checkIfPlayerHasTheDeck(deckName, Player.getLogedInPlayer()))
                System.out.print("you already have a deck with this name\n");
            else
                Player.getLogedInPlayer().addDeck(new Deck(deckName)); // should add deck's name
            return true;
        }
        return false;
    }

    public static boolean checkIfDeleteDeckCommandAndProcessIt(String command) {
        if (Pattern.compile("delete\\s+deck\\s+\\w", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String deckName = command.split("\\s+")[2];
            if (checkIfPlayerHasTheDeck(deckName, Player.getLogedInPlayer()))
                Player.getLogedInPlayer().deleteDeck(SearchingFunctions.findPlayerDeck(deckName, Player.getLogedInPlayer()));
            else
                System.out.print("you have no deck with this name\n");
            return true;
        }
        return false;
    }

    public static boolean checkIfAddCardToDeckCommandAndProcessIt(String command) {
        if (Pattern.compile("add\\s+\\w+\\s+to\\s+deck\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String cardOrItemName = command.split("\\s+")[1];
            String deckName = command.split("\\s+")[4];
            Card card = SearchingFunctions.findCardInCollection(cardOrItemName, Player.getLogedInPlayer());
            Deck deck = SearchingFunctions.findPlayerDeck(deckName, Player.getLogedInPlayer());
            if (card != null) {
                if (checkIfCardCanBeAddedToDeck(card, deck)) {
                    if (card instanceof Minion)
                        deck.addCard(card);
                    else if (card instanceof Hero)
                        deck.setHero((Hero) card);
                    System.out.print("card added to deck");
                }
            } else {
                Item item = SearchingFunctions.findItemInCollection(cardOrItemName, Player.getLogedInPlayer());
                if (item != null) {
                    if (deck.getItem() == null) {
                        deck.setItem(item);
                        System.out.print("item added to deck\n");
                    } else
                        System.out.print("there is already an item in this deck\n");
                } else {
                    System.out.print("no card or item with this name\n");
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkIfRemoveCardFromDeckCommandAndProcessIt(String command) {
        if (Pattern.compile("remove\\s+\\w+\\s+from\\s+deck\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String cardOrItemName = command.split("\\s+")[1];
            String deckName = command.split("\\s+")[4];
            Deck deck = SearchingFunctions.findPlayerDeck(deckName, Player.getLogedInPlayer());
            Card card = SearchingFunctions.findCardInCollection(cardOrItemName, Player.getLogedInPlayer());
            if (card != null) {
                if (checkIfCardCanBeRemovedFromTheDeck(card, deck)) {
                    if (card instanceof Minion) {
                        deck.removeCard(card);
                        System.out.print("card removed\n");
                    } else {
                        deck.removeHero();
                        System.out.print("Hero removed\n");
                    }
                }
            } else {
                Item item = SearchingFunctions.findItemInCollection(cardOrItemName, Player.getLogedInPlayer());
                if (item != null) {
                    if (deck.getItem() == item) {
                        deck.removeItem();
                        System.out.print("item removed\n");
                    } else
                        System.out.print("this item is not in this deck\n");
                } else {
                    System.out.print("you don't have this card");
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkIfValidateDeckCommandAndProcessIt(String command) {
        if (Pattern.compile("validate\\s+deck\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String deckName = command.split("\\s+")[2];
            Deck deck = SearchingFunctions.findPlayerDeck(deckName, Player.getLogedInPlayer());
            if (deck != null) {
                if (checkIfDeckIsValid(deck))
                    System.out.print("this deck is valid\n");
                else
                    System.out.print("this deck is not valid\n");
            } else
                System.out.print("you don't have any deck with this name\n");
            return true;
        }
        return false;
    }

    public static boolean checkIfSelectDeckCommandAndProcessIt(String command) {
        if (Pattern.compile("select\\s+deck\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            String deckName = command.split("\\s+")[2];
            Deck deck = SearchingFunctions.findPlayerDeck(deckName, Player.getLogedInPlayer());
            if (deck != null) {
                if (checkIfDeckIsValid(deck))
                    Player.getLogedInPlayer().setMainDeck(deck);
                else
                    System.out.print("this deck is not valid\n");
            } else
                System.out.print("you have no deck with this name\n");
            return true;
        }
        return false;
    }

    //
    //inBattleCommands

    public static boolean checkIfBattleShowCommandAndProcessIt(String command, Game game) {
        if (Pattern.compile("game\\s+info", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showGameInfo(Game.getOnGoingGame());
            return true;
        } else if (Pattern.compile("show\\s+my\\s+minions", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showPlayerMinions(Game.getOnGoingGame(), Game.getOnGoingGame().getTurn() % 2);
            return true;
        } else if (Pattern.compile("show\\s+opponent\\s+minions", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            if (Game.getOnGoingGame().getTurn() % 2 == 1)
                ShowCommands.showPlayerMinions(Game.getOnGoingGame(), 0);
            else
                ShowCommands.showPlayerMinions(Game.getOnGoingGame(), 1);
            return true;
        } else if (Pattern.compile("show\\s+card\\s+info\\s+\\w", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showCardInfo(command.split("\\s+")[3], Game.getOnGoingGame());
            return true;
        } else if (Pattern.compile("show\\s+hand", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            ShowCommands.showHand(game, game.getTurn() % 2);
            return true;
        }
        return false;
    }

    public static int returnPlayerNumberWhoWonTheGameMode1(Game game) {
        for (Card card : game.getCardsInMap().get(0)) {
            if (card instanceof Hero)
                if (((Hero) card).getHp() <= 0)
                    return 1;
        }
        for (Card card : game.getCardsInMap().get(1)) {
            if (card instanceof Hero)
                if (((Hero) card).getHp() <= 0)
                    return 0;
        }
        return -1;
    }
//
//    public static int returnPlayerNumberWhoWonTheGameMode2(Game game) {
//
//    }
//
//    public static int returnPlayerNumberWhoWonTheGameMode3(Game game) {
//
//    }

    public static boolean checkIfSelectCardCommandAndProcessIt(String command, Game game) {
        if (Pattern.compile("select\\s+\\w+", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            Card card = SearchingFunctions.findCardInGame(command.split("\\s+")[1], game);
            if (card != null)
                game.selectCard(card);
            else
                System.out.print("card with this id doesnt exists");
            return true;
        }
        return false;
    }

    public static boolean checkIfMoveCommandAndProcessIt(String command, Game game) {
        if (Pattern.compile("move\\s+to\\s+\\(\\d,\\d\\)", Pattern.CASE_INSENSITIVE).matcher(command).matches()) {
            if (game.getSelectedCard() != null) {
                int[] cardLocation = SearchingFunctions.getCardLocation(game, game.getSelectedCard());
                String location = command.split("\\s+")[2].substring(1, 4);
                int[] destination = new int[]{Integer.parseInt(location.substring(0, 1)),
                        Integer.parseInt(String.valueOf(location.charAt(2)))};
                if (Math.abs(cardLocation[0] - destination[0]) + Math.abs(cardLocation[1] - destination[1]) <= 2)
                    game.moveCard(game.getSelectedCard(), cardLocation, destination);
            }
            return true;
        }
        return false;
    }

    public static boolean checkIfInsertCardCommandAndProcessIt(String command, Game game) {
        if (Pattern.compile("insert\\s+\\w+\\s+in\\s+\\(\\d,\\d\\)").matcher(command).matches()) {
            String cardName = command.split("\\s+")[1];
            int[] destination = new int[]{Integer.parseInt(String.valueOf(command.split("\\s")[3].substring(1, 4).charAt(0))),
                    Integer.parseInt(String.valueOf(command.split("\\s")[3].substring(1, 4).charAt(2)))};
            Card card = SearchingFunctions.findCardInHand(cardName, game, game.getTurn() % 2);
            if (card != null) {
                if (game.getMap().getMapCells()[destination[0]][destination[1]].getCard() == null)
                    game.insertCard(card, destination[0], destination[1]);
                else
                    System.out.print("invalid target\n");
            } else
                System.out.print("invalid card name\n");
            return true;
        }
        return false;
    }

    public static boolean checkIfAttackCommandAndProccessIt(String command , Game game){

        return false ;
    }

    //
    //not categorized commands

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

    public static boolean checkIfPlayerHasTheCard(String cardName , Player player) {
        for(Card card : player.getCollection().getCards()){
            if(card.getName().equalsIgnoreCase(cardName))
                return true;
        }
        return false;
    }

    public static boolean checkIfPlayerHasTheDeck(String deckName, Player player) {
        for (Deck deck : player.getDecks()) {
            if (deck.getName().equals(deckName))
                return true;
        }
        return false;
    }

    public static boolean checkIfCardCanBeAddedToDeck(Card card, Deck deck) {
        if (card instanceof Minion) {
            if (!deck.getCards().contains(card)) {
                if (deck.getCards().size() != 20)
                    return true;
                else {
                    System.out.print("the deck is full\n");
                    return false;
                }
            } else {
                System.out.print("the card is already in this deck\n");
                return false;
            }
        }
        if (card instanceof Hero) {
            if (deck.getHero() == null)
                return true;
            else {
                System.out.print("there is already a hero in this deck\n");
                return false;
            }
        }
        return false;
    }

    public static boolean checkIfCardCanBeRemovedFromTheDeck(Card card, Deck deck) {
        if (card instanceof Minion) {
            if (deck.getCards().contains(card))
                return true;
            else {
                System.out.print("no card with this name in this");
                return false;
            }
        } else if (card instanceof Hero) {
            if (deck.getHero() == card)
                return true;
            else {
                System.out.print("this Hero is not in this deck\n");
                return false;
            }
        }
        return false;
    }

    public static boolean checkIfDeckIsValid(Deck deck) {
        if (deck.getCards().size() == 20 && deck.getHero() != null)
            return true;
        else
            return false;
    }

    public static boolean checkIfItemExistsInShop(String itemName) {
        for (Item item : Item.getItems()) {
            if (item.getName().equals(itemName))
                return true;
        }
        return false;
    }

    public static boolean checkIfTheCardsAreForAPlayer(Card firstCard , Card secondCard , Game game){
        boolean hasFirstCard = false , hasSecondCard = false ;
        for(int i = 0 ; i <= 1 ; i++) {
            for (Card card : game.getCardsInMap().get(i)){
                if(card == firstCard)
                    hasFirstCard = true ;
                else if(card == secondCard)
                    hasSecondCard = true ;
            }
        }
        if(hasFirstCard && hasSecondCard)
            return true ;
        hasFirstCard = false ; hasSecondCard = false;
        for(int i = 0 ; i <= 1 ; i++) {
            for (Card card : game.getCardsInHand().get(i)){
                if(card == firstCard)
                    hasFirstCard = true ;
                else if(card == secondCard)
                    hasSecondCard = true ;
            }
        }
        if(hasFirstCard && hasSecondCard)
            return true ;
        return false ;
    }

    public static boolean checkIfAttackingIsPossible(Card attacker , Card defender , int distance){

        return false ;
    }//not complete
}
