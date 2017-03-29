/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimateleague;

/**
 *
 * @author Mary
 */
public class UltimateLeagueClass {
    
    //variables (store from database when connected)
    int playerID;
    String firstName;
    String lastName;
    int skillLevel;
    int playersPreferences;
    int playersChoices;
    
    //constructor
    public UltimateLeagueClass(int playerID, String firstName, String lastName, int skillLevel, int playersPreferences, int playersChoices)
    {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillLevel = skillLevel;
        this.playersPreferences = playersPreferences;
        this.playersChoices = playersChoices;
    }
    
    //sets
    public void setPlayerID(int playerID)
    {
       this.playerID = playerID; 
    }
    public void setFirstName(String firstName)
    {
       this.firstName = firstName; 
    }
    public void setLastName(String lastName)
    {
       this.lastName = lastName; 
    }
    public void setSkillLevel(int skillLevel)
    {
       this.skillLevel = skillLevel; 
    }
    public void setPlayersPreferences(int playersPreferences)
    {
       this.playersPreferences = playersPreferences; 
    }
    public void setplayersChoices(int playersChoices)
    {
       this.playersChoices = playersChoices; 
    }
    
    //gets
    public int getPlayerID()
    {
        return playerID;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getSkillLevel()
    {
        return skillLevel;
    }
    public int getPlayersPreferences()
    {
        return playersPreferences;
    }
    public int getPlayersChoices()
    {
        return playersChoices;
    }
}
