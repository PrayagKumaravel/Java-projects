package terminal.PLAYER_DETAILS_STORAGE;

import terminal.ALL_GAMES.*;
import terminal.JDBC_CONNECT.*;

import java.util.*;

public class PLAYER_DETAILS {
    public static void player_details(Scanner pr,String first_player,String second_player,String winner_name) throws Exception{
        String game_name=ALL_GAME.game_name;
        JDBC_CONNECTION.jdbc_player(pr,first_player,second_player,game_name,winner_name);
    }
}
