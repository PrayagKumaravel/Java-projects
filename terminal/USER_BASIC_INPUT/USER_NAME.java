package terminal.USER_BASIC_INPUT;
import java.util.*;
public class USER_NAME {
    public static String[] user_name(Scanner pr,int user_number){
        String[] naming=new String[2];
        pr.nextLine();
        System.out.print("Enter the name of player 1: ");
        naming[0]=pr.nextLine();
        System.out.print("Enter the name of player 2: ");
        naming[1]=pr.nextLine();
        System.out.println("********************");
        return naming;
    }
    public static String user_name(Scanner pr){
        pr.nextLine();
        System.out.print("Enter the name of player : ");
        String naming=pr.nextLine();
        System.out.println("********************");
        return naming;
    }
}
