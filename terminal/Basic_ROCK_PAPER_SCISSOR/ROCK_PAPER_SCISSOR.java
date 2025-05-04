package terminal.Basic_ROCK_PAPER_SCISSOR;
import java.util.*;

import terminal.USER_BASIC_INPUT.*;
import terminal.PLAYER_DETAILS_STORAGE.*;

public class ROCK_PAPER_SCISSOR {
    static String[] naming=new String[2];
    static String winner_name;
    public  static void rock_paper_scissor(Scanner pr) throws Exception{
        rules();
        if(decision(pr)){
            //pr.nextLine();
            naming=USER_NAME.user_name(pr,2);
            play(pr);
            PLAYER_DETAILS.player_details(pr, naming[0],naming[1], winner_name);
        }
        else{
            System.out.print("Try playing next time if you wish !!");
        }
    }
    public static boolean decision(Scanner pr){
        System.out.println("Would you like to play Rock PAPER SCISSOR GAME?(1/0)");
        int entry=pr.nextInt();
        return entry==1?true:(quit(pr)?false:true);
    }
    public static boolean quit(Scanner pr){
        System.out.print("Would you like to quit?(1/0) ");
        int quiting_status=pr.nextInt();
        return quiting_status==1;
    }
    public static void rules(){
        System.out.println("Welcome to this ROCK PAPER SCISSOR game ");
        System.out.println("This is a multiplayer game , ther person who scores 5 points first is considered to be the winner.");
        System.out.println("The priority order for points:\n1)Rock beats scissor(the person with rock gets 1 point)\n2)paper beats rock(the person with paper gets 1 point)\n3)scissor beats paper(the person with scissor gets 1 point)\n4)If both inputs are same , no points");
    }
    public static void play(Scanner pr){
        String[] input=new String[2];
        int[] points=new int[2];
        while(points[0]<5 || points[1]<5){
            System.out.println("********************");
            System.out.print(naming[0]+" turn-> Enter your input: ");
            input[0]=pr.next();
            System.out.print(naming[1]+" turn-> Enter your input: ");
            input[1]=pr.next();
            if((input[0].toLowerCase().equals("rock") && input[1].toLowerCase().equals("scissor")) || (input[0].toLowerCase().equals("scissor") && input[1].toLowerCase().equals("paper")) || (input[0].toLowerCase().equals("paper") && input[1].toLowerCase().equals("rock"))){
                points[0]+=1;
            }
            else if((input[1].toLowerCase().equals("rock") && input[0].toLowerCase().equals("scissor")) || (input[1].toLowerCase().equals("scissor") && input[0].toLowerCase().equals("paper")) || (input[1].toLowerCase().equals("paper") && input[0].toLowerCase().equals("rock"))){
                points[1]+=1;
            }
            else if(input[0].equals(input[1])){
                continue;
            }
            else{
                System.out.print("Invalid sign try again!!\n");
            }
            if(points[0]==5 || points[1]==5){
                break;
            }
        }
        System.out.println("********************");
        winner_name=points[0]==5?naming[0]:naming[1];
        System.out.println(points[0]==5?naming[0]+" wins the game!! ":naming[1]+" wins the game!! ");
        System.out.print("********************");
    }
}
