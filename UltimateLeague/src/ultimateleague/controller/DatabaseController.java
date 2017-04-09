package ultimateleague.controller;

import quick.dbtable.DBTable;

import java.beans.Statement;
import java.sql.*;

/**
 * Created by grturner on 3/29/2017.
 */
public class DatabaseController {
    private final String SERVER = "db1.5x5code.com:3306";
    private final String SCHEMA = "ultimate_league";
    private final String USER = "triad_ultimate";
    private final String PASS = "a29me46DF4m8bcc";
    private Connection mConnection;
    private boolean mIsConnected = false;

    public DatabaseController(){
        connect();
    }
    
    public void executeQuery(String query){
        // TODO: 3/30/2017 code to execute query 
    }

    public ResultSet getResults(String query){
        ResultSet resultSet = null;
        while(!mIsConnected) {
            connect();
        }
        try {
            PreparedStatement preparedStatement = mConnection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return resultSet;
    }

    private void connect() {
        mConnection = null;
        try {
            mConnection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + SCHEMA + "?user=" +
                    USER + "&password=" + PASS + "&useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC");
            mIsConnected = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            mIsConnected = false;
        }
    }
}