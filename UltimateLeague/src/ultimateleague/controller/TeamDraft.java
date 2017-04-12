package ultimateleague.controller;

import ultimateleague.model.DraftTeam;
import ultimateleague.model.Player;

import java.util.ArrayList;

public class TeamDraft {
  private ArrayList<Player> mPlayerList;
  private int mNumTeams;

  public TeamDraft(ArrayList<Player> playerList, int numTeams){
      this.mPlayerList = playerList;
      this.mNumTeams = numTeams;
  }

  public void makeTeams(){
      ArrayList<DraftTeam> draftTeams = new ArrayList<>();

      /* Creates the desired number of teams */
      for (int x = 0; x < mNumTeams; x++){
          DraftTeam team = new DraftTeam();
          draftTeams.add(team);
      }

      /* Place player */
      for (Player player: mPlayerList) {
          double[] teamAverages;
          int playerSkill = Integer.parseInt(player.getSkill());
          for (int x = 0; x < mNumTeams; x++){

          }
      }
  }
}
