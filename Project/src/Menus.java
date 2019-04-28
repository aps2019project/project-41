import java.util.regex.Pattern;

// watch starting deriks of the player when creating it in creat account command
public class Menus {
    public static int loginMenu() {
        String command;
        while (true) {
            command = Scanners.input.nextLine().trim();
            if (checkingFunctions.checkIfAddAccountCommandAndProccessIt(command)) ;
            else if (checkingFunctions.checkIfLoginCommandAndProccessIt(command))
                return 1 ;
        }
    }
}

class checkingFunctions {
    public static boolean checkIfAddAccountCommandAndProccessIt(String command) {
        if (Pattern.compile("create\\s+account\\s+\\w+]").matcher(command).matches()) {
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
        if(Pattern.compile("login\\s+\\w+").matcher(command).matches())
        {
            String splitedCommand[] = command.split("\\s+") ;
            if(checkIfUserNameExists(splitedCommand[1]))
            {
                String password = Scanners.input.nextLine().trim() ;
                Player player = findPlayer(splitedCommand[1]) ;
                if(player.getPassword().equals(password))
                {
                    Player.logIn(player);
                    return true ;
                }
                else
                    System.out.print("wrong password\n");
            }
            else
                System.out.print("username not found\n") ;
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

    public static Player findPlayer(String userName)
    {
        for(Player player : Player.getPlayers())
            if(player.getUserName().equals(userName))
                return player ;
        return null ;

    }
}
