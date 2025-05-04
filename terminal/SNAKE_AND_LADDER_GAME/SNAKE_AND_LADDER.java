package terminal.SNAKE_AND_LADDER_GAME;
import java.util.*;

import terminal.USER_BASIC_INPUT.USER_NAME;
import terminal.PLAYER_DETAILS_STORAGE.*;

public class SNAKE_AND_LADDER {
    static String[] naming=new String[2];
    static String winner_name;
    public static void snake_and_ladder(Scanner pr) throws Exception{
        rules();
        if(descision(pr)){
            //pr.nextLine();
            naming=USER_NAME.user_name(pr, 2);
            play(pr);
            PLAYER_DETAILS.player_details(pr,naming[0],naming[1],winner_name);
        }
        else{
            System.out.println("Try playing next time if you wish!! ");
        }

    }
    public static boolean descision(Scanner pr){
        System.out.print("Would you like to play the game?(1/0) ");
        int decisioning=pr.nextInt();
        return decisioning==1?true:(quit(pr)?false:true);
    }
    public static boolean quit(Scanner pr){
        System.out.print("WOuld you like to quit the game?(1/0) ");
        int quiting_status=pr.nextInt();
        return quiting_status==1;
    }
    public static void rules(){
        String a="""
                This game uses dice to more forward to next level.
                The first person who reaches level 100 is considered to be the winner of the game.
                There are snakes and ladders in some level.
                Once if the snake bites the player he will go to some lower level.
                once if he reaches the level which has ladder , he will go to some level higher directly
                
                This the list of snakes and ladder available and changes in level when you find snake or ladder

                LEVEL        SNAKE        LADDER       LEVEL(UPDATE)
                 20           YES           NO               10
                 25           NO            YES              31
                 40           NO            YES              56
                 57           YES           NO               39
                 60           YES           NO               47
                 71           NO            YES              82
                 81           YES           NO               56
                 85           NO            YES              93
                 90           NO            YES              96
                 94           YES           NO               1
                 97           YES           NO               50
                """;
        System.out.println("This is a multiplayer game.");
        System.out.println(a);
    }
    public static void play(Scanner pr){
        int user1=0;
        int level_first=1,level_second=1;
        while(level_first<100 && level_second<100){
            int roll_dice=0;
            int temp_level;
            while(roll_dice!=1){
                if(user1==0){
                    System.out.print(naming[0]+" turn -> ");
                }
                else{
                    System.out.print(naming[1]+" turn -> ");
                }
                System.out.print("Enter 1 to roll the dice: ");
                roll_dice=pr.nextInt();
            }
            if(user1==0){
                user1=1;
                level_first+=(int)((Math.random()*6)+1);
                System.out.println("reached level -> "+level_first);
                temp_level=level_first;
                level_first=snake(level_first)==level_first?ladder(level_first):snake(level_first);
                System.out.println(level_first<temp_level?"GOT BITTINGS FROM SNAKE AND WENT DOWN":(level_first>temp_level?"GOT AN LADDER AND WENT UP.":"NO SNAKES OR LADDER ARE FOUND"));
                if(level_first>=100){
                    System.out.println("*************************");
                    break;
                }
                System.out.println(naming[0]+" -> level "+level_first);
            }
            else{
                user1=0;
                level_second+=(int)((Math.random()*6)+1);
                System.out.println("reached level -> "+level_second);
                temp_level=level_second;
                level_second=snake(level_second)==level_second?ladder(level_second):snake(level_second);
                System.out.println(level_second<temp_level?"GOT BITTINGS FROM SNAKE AND WENT DOWN":(level_second>temp_level?"GOT AN LADDER AND WENT UP":"NO SNAKES OR LADDERS ARE FOUND"));
                if(level_second>=100){
                    System.out.println("*************************");
                    break;
                }
                System.out.println(naming[1]+" -> level "+level_second);
            }
            System.out.println("*************************");
        }
        if(level_first>=100){
            winner_name=naming[0];
            System.out.println(naming[0]+" WON THE GAME!!");
        }
        else{
            winner_name=naming[1];
            System.out.println(naming[1]+" WON THE GAME!!");
        }
    }
    public static int snake(int level){
        level=switch(level){
            case 20->10;
            case 57->30;
            case 60->47;
            case 81->56;
            case 94->1;
            case 97->50;
            default->level;
        };
        return level;
    }
    public static int ladder(int level){
        level=switch(level){
            case 25->31;
            case 40->56;
            case 71->82;
            case 85->93;
            case 90->96;
            default->level;
        };
        return level;
    }
}
