// not considering equal wins in sortPlayersByWin

public class SortingFunctions {
    public static void sortPlayersByWin()
    {
        int i , j ;
        for(i = 0 ; i < Player.getPlayers().size() ; i++)
        {
            for(j = 0 ; j < Player.getPlayers().size() - 1 ; j++)
            {
                if(Player.getPlayers().get(j+1).getWins() > Player.getPlayers().get(j).getWins())
                {
                    Player tempPlayer = Player.getPlayers().get(j) ;
                    Player.getPlayers().set(j , Player.getPlayers().get(j+1)) ;
                    Player.getPlayers().set(j+1 , tempPlayer) ;
                }
            }
        }
    }

}
