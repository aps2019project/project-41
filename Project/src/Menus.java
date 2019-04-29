import java.util.regex.Pattern;

// watch starting deriks of the player when creating it in creat account command
public class Menus {
    public static int mainMenu() {

    }

    public static int loginMenu() {
        String command;
        while (true) {
            command = Scanners.input.nextLine().trim();
            if (command.equalsIgnoreCase("exit"))
                return -1;
            else if (CheckingFunctions.checkIfCreateAccountCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfLoginCommandAndProccessIt(command))
                return 1;
            else if (CheckingFunctions.checkIfShowLeaderBoardCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfSaveCommandAndProccessIt(command)) ;
            else if (CheckingFunctions.checkIfLogOutCommandAndProccessIt(command))
            {
                if(Menus.loginMenu() == -1)
                    return -1 ;
            }
            else if (command.equalsIgnoreCase("help"))
                ShowCommands.showLoginMenuCommands();

        }
    }
}
