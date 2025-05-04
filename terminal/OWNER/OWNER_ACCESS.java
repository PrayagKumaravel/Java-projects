package terminal.OWNER;

import terminal.JDBC_CONNECT.*;
import java.util.*;
public class OWNER_ACCESS {
    public static void owner_access(Scanner pr) throws Exception{
        System.out.println("Would you like to work with user database?(1/0) ");
        int owner_input=pr.nextInt();
        if(owner_input==1){
            JDBC_CONNECTION.jdbc_owner(pr);
        }
        else{
            JDBC_CONNECTION.jdbc_exit();
        }
    }
}
