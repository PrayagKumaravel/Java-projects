package terminal.STARTING;
import java.util.*;

import terminal.ACESS_LEVEL.*;

public class START {
    public static void main(String[] args) throws Exception{
        Scanner pr=new Scanner(System.in);
        ACCESS_LEVEL_DEV.user_access_level(pr);
    }
}