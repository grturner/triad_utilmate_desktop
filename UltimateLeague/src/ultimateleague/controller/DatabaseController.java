package ultimateleague.controller;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by grturner on 3/29/2017.
 */
public class DatabaseController {
    private final String SERVER = "db1.5x5code.com:3306";
    private final String SCHEMA = "ultimate_league";
    private final String USER = "triad_ultimate";
    private final String PASS = "a29me46DF4m8bcc";
    private Statement mStatement;
    private Connection mConnection;
    private boolean mIsConnected = false;

    public DatabaseController(){
        mConnection = null;
        try {
            mConnection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + SCHEMA + "?user=" +
                    USER + "&password=" + PASS);
            mIsConnected = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void executeQuery(String query){
        // TODO: 3/30/2017 code to execute query 
    }
}