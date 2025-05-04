package Basic_XO_Game;
import java.util.*;

import terminal.USER_BASIC_INPUT.*;
import terminal.PLAYER_DETAILS_STORAGE.*;

public class XO_GAME{
    static String[] naming=new String[2];
    static String winner_name;
    static int rounds_count=0;
    public static void xo_game(Scanner pr) throws Exception{
        rules();
        if(decision(pr)==0){
            System.out.print("Terminated...");
        }
        else{
            //pr.nextLine();
            naming=USER_NAME.user_name(pr,2);
            play(pr);
            PLAYER_DETAILS.player_details(pr,naming[0],naming[1],winner_name);
        }
    }
    public static int decision(Scanner pr){
        System.out.println("Would you like to play XO game?(1/0) ");
        int decisioning=pr.nextInt();
        //pr.close();
        return decisioning==0?(quit(pr)==1?0:1):1;
    }
    public static int quit(Scanner pr){
        System.out.println("Would you like to quit?(1/0) ");
        int quiting=pr.nextInt();
        //pr.close();
        return quiting;
    } 
    public static void rules(){
        System.out.println("This XO game consists of 9 tiles and this is a multiplayer game (person 1, person 2).");
        System.out.println("The person should plot thier symbol or sign as a straight line first inorder to win the opponent.");
        System.out.println("********************");
    }
    public static void play(Scanner pr){
        //String[][] space=new String[3][3];
        int user1=0;
        String[][] space=storeA();
        int count=0;
        while(true){
            count++;
            if(user1==0){
                user1=1;
                while(true){
                    System.out.print("User : "+naming[0]+" turn: ");
                    System.out.print("Enter the position to place X: ");
                    int a=pr.nextInt();
                    int b=pr.nextInt();
                    if(space[a][b].equals("A")){
                        space[a][b]="X";
                        break;
                    }
                    else{
                        System.out.println("Already occupied ...TRY AGAIN!!");
                    }
                }
            }
            else{
                user1=0;
                while(true){
                    System.out.print("User: "+naming[1]+" turn: ");
                    System.out.print("Enter the position to place O: ");
                    int a=pr.nextInt();
                    int b=pr.nextInt();
                    if(space[a][b].equals("A")){
                        space[a][b]="O";
                        break;
                    }
                    else{
                        System.out.println("Already occupied...TRY AGAIN");
                    }
                }
            }
            if(check(space)){
                break;
            }
            else{
                rounds_count++;
            }
            if(rounds_count==9){
                winner_name="DRAW";
                System.out.println("Match draw between "+naming[0]+" and "+naming[1]);
                break;
            }
            if(count==2){
                System.out.println("********************");
                count=0;
            }
        }
    }
    public static boolean check(String[][] space){
        
        for(int i=0;i<space.length;i++){
            int counthx=0,countho=0;
            int countvx=0,countvo=0;
            int countd1x=0,countd2x=0;
            int countd1o=0,countd2o=0;
            int k=space[i].length-1;
            for(int j=0;j<space[i].length;j++){
                counthx+=space[i][j]=="X"?1:0;
                countho+=space[i][j]=="O"?1:0;
                countvx+=space[j][i]=="X"?1:0;
                countvo+=space[j][i]=="O"?1:0;
                countd1x+=space[j][j]=="X"?1:0;
                countd2x+=space[j][k]=="X"?1:0;
                countd1o+=space[j][j]=="O"?1:0;
                countd2o+=space[j][k]=="O"?1:0;
                k--;
                if(counthx==3 || countvx==3 || countd1x==3 || countd2x==3){
                    System.out.print("User: "+naming[0]+" Wins !! ");
                    winner_name=naming[0];
                    return true;
                }
                else if(countho==3 || countvo==3 || countd1o==3 || countd2o==3){
                    System.out.print("User: "+naming[1]+" Wins !! ");
                    winner_name=naming[1];
                    return true;
                }
            }
        }
        return false;
    }
    public static String[][] storeA(){
        String[][] space=new String[3][3];
        for(int i=0;i<space.length;i++){
            for(int j=0;j<space[i].length;j++){
                space[i][j]="A";
            }
        }
        return space;
    }
}