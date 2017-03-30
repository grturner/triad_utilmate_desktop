package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Season implements java.io.Serializable {
    private String mSeasonId;
    private String mTeamMatePrefs;
    private String mAvailableDate;
    private String mSeasonName;

    public String getSeasonId() {
        return mSeasonId;
    }

    public void setSeasonId(String seasonId) {
        mSeasonId = seasonId;
    }

    public String getTeamMatePrefs() {
        return mTeamMatePrefs;
    }

    public void setTeamMatePrefs(String teamMatePrefs) {
        mTeamMatePrefs = teamMatePrefs;
    }

    public String getAvailableDate() {
        return mAvailableDate;
    }

    public void setAvailableDate(String availableDate) {
        mAvailableDate = availableDate;
    }

    public String getSeasonName() {
        return mSeasonName;
    }

    public void setSeasonName(String seasonName) {
        mSeasonName = seasonName;
    }
}
