package ultimateleague.model;

import java.util.ArrayList;

/**
 * Created by grturner on 4/11/17.
 */
public class DraftTeam {
    private ArrayList<Player> mTeamPlayers;
    private double mAvgRank;
    private int mNumPlayers;

    public DraftTeam() {
        this.mTeamPlayers = new ArrayList<>();
        this.mAvgRank = 0.0;
        this.mNumPlayers = 0;
    }

    public void addPlayer(Player player) {
        mTeamPlayers.add(player);
        mNumPlayers++;
        updateAverage();
    }

    public void updateAverage() {
        double totalPoints = 0.0;
        int numPlayers = 0;
        for (Player player : mTeamPlayers) {
            totalPoints += player.getSkill();
            numPlayers += 1;
        }
        mAvgRank = totalPoints / (double) numPlayers;
    }

    public double getAvgRank() {
        return mAvgRank;
    }

    public int getNumPlayers(){
        return mNumPlayers;
    }
}