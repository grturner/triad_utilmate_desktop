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
        mPlayerList = playerList;
        mNumTeams = numTeams;
        makeTeams();
    }

    private void makeTeams() {
        int teamCounter;
        mDraftTeams = new ArrayList<>();

        /* Calculate Baseline Average of Players */
        mPlayerAvg = 0.0;
        for (int i = 0; i < mPlayerList.size(); i++) {
            mPlayerAvg += mPlayerList.get(i).getSkill() + 0.0;
        }
        mPlayerAvg = mPlayerAvg / (mPlayerList.size() + 0.0);
        System.out.println("TeamDraft::makeTeams - mPlayerAvg = " + String.valueOf(mPlayerAvg));

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
        do {
            if (teamCounter >= mDraftTeams.size()){
                teamCounter = 0;
            }
            DraftTeam team;
            team = mDraftTeams.get(teamCounter);
            if (team.getAvgRank() < mPlayerAvg) {
                Player player = Collections.max(mPlayerList);
                team.addPlayer(player);
                mPlayerList.remove(player);
            } else {
                Player player = Collections.min(mPlayerList);
                mPlayerList.remove(player);
                team.addPlayer(player);
            }
            teamCounter += 1;
        } while (mPlayerList.size() > 0);
        for (DraftTeam team : mDraftTeams){
            // System.out.println("TeamDraft::makeTeams - " + team.toString());
            ArrayList<Player> players =  team.getTeamPlayers();
            // for(Player player : players) {
            //     System.out.println("TeamDraft::makeTeams - " + player.toString());
            // }
        }
    }

    public ArrayList<DraftTeam> getTeams(){
        return mDraftTeams;
    }
}
