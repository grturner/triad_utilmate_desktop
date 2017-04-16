package ultimateleague.controller;

import ultimateleague.model.DraftTeam;
import ultimateleague.model.Player;

import java.util.ArrayList;
import java.util.Collections;

public class TeamDraft {
    private ArrayList<Player> mPlayerList;
    private int mNumTeams;
    private double mPlayerAvg;
    ArrayList<DraftTeam> mDraftTeams;

    public TeamDraft(ArrayList<Player> playerList, int numTeams) {
        this.mPlayerList = playerList;
        this.mNumTeams = numTeams;
        makeTeams();
    }

    private void makeTeams() {
        int teamCounter;
        mDraftTeams = new ArrayList<>();

        /* Calculate Baseline Average of Players */
        mPlayerAvg = 0;
        for (Player player : mPlayerList) {
            mPlayerAvg += player.getSkill();
        }
        mPlayerAvg = mPlayerAvg / mPlayerList.size();

      /* Creates the desired number of teams */
        for (int x = 0; x < mNumTeams; x++) {
            DraftTeam team = new DraftTeam();
            mDraftTeams.add(team);
        }

        /*
        *   Loop through teams and pick players while the Player
        *   array is not empty.
         */
        teamCounter = 0;
        while (mPlayerList.size() > 0) {
            if (teamCounter >= mDraftTeams.size()){
                teamCounter = 0;
            }
            DraftTeam team;
            team = mDraftTeams.get(teamCounter);
            if (team.getAvgRank() < mPlayerAvg) {
                Player player = Collections.max(mPlayerList);
                mPlayerList.remove(player);
                team.addPlayer(player);
            } else {
                Player player = Collections.min(mPlayerList);
                mPlayerList.remove(player);
                team.addPlayer(player);
            }
            teamCounter += 1;
        }

    }

    public ArrayList<DraftTeam> getTeams(){
        return mDraftTeams;
    }
}
