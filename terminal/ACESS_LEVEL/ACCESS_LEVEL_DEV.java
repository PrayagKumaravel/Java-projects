package terminal.ACESS_LEVEL;
import java.util.*;

import terminal.OWNER.*;
import terminal.ALL_GAMES.*;

public class ACCESS_LEVEL_DEV {
    public static void user_access_level(Scanner pr) throws Exception{
        System.out.print("Enter player/owner? ");
        String user_type=pr.nextLine();
        if(user_type.toLowerCase().equals("owner")){
            int i=0;
            while(i<5){
                System.out.print("Enter your name: ");
                String owner_name=pr.nextLine();
                System.out.print("Enter your password: ");
                String password=pr.next();
                if(owner_name.equals("prayag") && password.equals("Prahar@08")){
                    System.out.println("you are the owner");
                    OWNER_ACCESS.owner_access(pr);
                    break;
                }
                else{
                    System.out.println("\nInvalid combination of username and password!!\n");
                    pr.nextLine();
                    i++;
                }
            }
            
        }
        else{
            ALL_GAME.all_games(pr);
        }
    }
}
