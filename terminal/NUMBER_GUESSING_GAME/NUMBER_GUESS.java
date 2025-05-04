package terminal.NUMBER_GUESSING_GAME;
import java.util.*;

import terminal.USER_BASIC_INPUT.USER_NAME;
import terminal.PLAYER_DETAILS_STORAGE.*;

public class NUMBER_GUESS {
    static String naming;
    static String winner_name;
    public static void number_guess(Scanner pr) throws Exception{
        rules();
        if(decision(pr)){
            //pr.nextLine();
            naming=USER_NAME.user_name(pr);
            play(pr);
            PLAYER_DETAILS.player_details(pr,naming,"computer",winner_name);
        }
        else{
            System.out.print("Try playing next time!!");
        }
    }
    public static boolean decision(Scanner pr){
        System.out.print("Would you like to play NUMBER GUESS game?(1/0) ");
        int decisioning=pr.nextInt();
        return decisioning==1?true:(quit(pr)?false:true);
    }
    public static boolean quit(Scanner pr){
        System.out.print("Would you like to quit this game?(1/0) ");
        int quiting_status=pr.nextInt();
        return quiting_status==1;
    }
    public static void rules(){
        System.out.println("This is a single player game ");
        System.out.println("Here already a random number will be taken by computer , and next you need to enter your guessed number(0-100).");
        System.out.println("If you input (guessed number) is as same as the computer considered number , then you win the match.");
        System.out.println("If not you lose.");
        System.out.println("You will be given 10 chances to guess the number ");
    }
    public static void play(Scanner pr){
        int computer_number=(int)(Math.random()*100);
        //System.out.println(computer_number);
        System.out.println("The game starts "+naming);
        int chances=1,user_input,failed_chances=0,warning=0;
        while(chances<=10 && warning<3){
            System.out.print("CHANCE "+chances+"->Enter your guessed number(0-100): ");
            user_input=pr.nextInt();
            if(user_input>100){
                warning++;
                System.out.println("WARNING "+warning);
                System.out.println("YO BRUHH !! DON'T ENTER OUT OF RANGE");
                continue;
            }
            if(user_input==computer_number){
                winner_name=naming;
                System.out.print(naming+" beats the computer ");
                break;
            }
            else{
                failed_chances+=1;
            }
            chances++;
        }
        if(failed_chances==10 || warning==3){
            winner_name="computer";
            System.out.print("computer beats "+naming);
        }
    }
}
