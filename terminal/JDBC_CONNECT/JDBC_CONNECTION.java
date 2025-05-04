package terminal.JDBC_CONNECT;
import java.util.*;
import java.sql.*;
public class JDBC_CONNECTION{
    public static Connection jdbc_connection() throws Exception{
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/games_user","root","Prahar@08");
        return con;
    }
    public static void jdbc_owner(Scanner pr) throws Exception{
        Connection con=jdbc_connection();
        pr.nextLine();
        System.out.print("Enter the query to work with database: ");
        String query=pr.nextLine();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        System.out.println("LIST OF PLAYERS WHO TESTED OUR MINI TERMINAL PROJECT ");
        while(rs.next()){
            System.out.println("game_number: "+rs.getInt("game_number"));
            System.out.println("first_player_name: "+rs.getString("first_player_name"));
            System.out.println("second_player_name: "+rs.getString("second_player_name"));
            System.out.println("game_name: "+rs.getString("game_name"));
            System.out.println("winner_name: "+rs.getString("winner_name"));
            System.out.println("******************************");
        }
    }
    public static void jdbc_player(Scanner pr,String first_player,String second_player,String game_name,String winner_name) throws Exception{
        Connection con=jdbc_connection();
        String query="insert into players_list(first_player_name,second_player_name,game_name,winner_name) values(?,?,?,?)";
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,first_player);
        st.setString(2,second_player);
        st.setString(3,game_name);
        st.setString(4,winner_name);
        st.executeUpdate();
    }
    public static void jdbc_exit(){
        System.out.println("EXITING!!!!");
    }
}