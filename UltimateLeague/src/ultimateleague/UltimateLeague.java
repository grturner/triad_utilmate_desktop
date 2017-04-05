package ultimateleague;

import javax.swing.*;
import java.sql.*;

/**
 * Ultimate League
 * @author Initech
 * Spring 2017
 */

public class UltimateLeague {
    private static JFrame sFrame;

    public static void main(String[] args) {
     
/*        final String DB_URL = "jdbc:mysql://192.111.147.77:3306/triad_ultimate";

        try{//try to connect to the database
           Connection connection = DriverManager.getConnection(DB_URL, "triad_ultimate", "a29me46DF4m8bcc");

           System.out.println("Connection established.");

           try{//try to create a statement on the connection
               Statement statement = connection.createStatement();
               System.out.println("Statement created.");

               //write SQL commands
               String selectAll = "select * Players (PLAYER_ID)";
               //String insertData = "insert into Players (PLAYER_ID) values (123456)";

               //execute the sql commands
               //statement.executeUpdate(insertData);
               //statement.executeUpdate(insertData);

               //retrieve data from the table
               ResultSet result = statement.executeQuery(selectAll);
               while(result.next())
               {
                   System.out.println(result.getInt("Player ID") + "\t" + result.getInt(0));
               }

           }catch(SQLException ex)
            {
                System.out.println(ex);
            }
        }catch(SQLException ex)
        {
            System.out.println("Connection failed");
        }*/
        sFrame = new Frame();
        sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sFrame.setSize(800, 600);
        sFrame.setVisible(true);
    }
}
    

