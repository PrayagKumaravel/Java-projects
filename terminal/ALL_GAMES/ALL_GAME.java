package terminal.ALL_GAMES;

import terminal.Basic_ROCK_PAPER_SCISSOR.*;
import Basic_XO_Game.*;
import terminal.NUMBER_GUESSING_GAME.*;
import terminal.SNAKE_AND_LADDER_GAME.*;

import java.util.*;
public class ALL_GAME {
    public static String game_name;
    public static void all_games(Scanner pr) throws Exception{
        System.out.println("Currently this is under developement...\nwe have only three games.");
        System.out.print("1)TIC TAC TOE\n2)ROCK PAPER SCISSOR\n3)NUMBER GUESS\n4)SNAKE AND LADDER\n5)EXIT\nEnter the name of the game to play: ");
        game_name=pr.nextLine();
        if(game_name.toUpperCase().equals("TIC TAC TOE")){
            XO_GAME.xo_game(pr);
        }
        else if(game_name.toUpperCase().equals("ROCK PAPER SCISSOR")){
            ROCK_PAPER_SCISSOR.rock_paper_scissor(pr);
        }
        else if(game_name.toUpperCase().equals("NUMBER GUESS")){
            NUMBER_GUESS.number_guess(pr);
        }
        else if(game_name.toUpperCase().equals("SNAKE AND LADDER")){
            SNAKE_AND_LADDER.snake_and_ladder(pr);
        }
        else if(game_name.toUpperCase().equals("EXIT")){
            System.out.println("Exiting the program...");
        }
        else{
            System.out.println("Invalid game name !! ");
        }
    }
}