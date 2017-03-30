package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Team implements java.io.Serializable {
    private String mTeamId;
    private String mTeamName;
    private String mTeamColors;
    private String mTeamRank;
    private String mLeagueName;

    public String getTeamId() {
        return mTeamId;
    }

    public void setTeamId(String teamId) {
        mTeamId = teamId;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public void setTeamName(String teamName) {
        mTeamName = teamName;
    }

    public String getTeamColors() {
        return mTeamColors;
    }

    public void setTeamColors(String teamColors) {
        mTeamColors = teamColors;
    }

    public String getTeamRank() {
        return mTeamRank;
    }

    public void setTeamRank(String teamRank) {
        mTeamRank = teamRank;
    }

    public String getLeagueName() {
        return mLeagueName;
    }

    public void setLeagueName(String leagueName) {
        mLeagueName = leagueName;
    }
}
