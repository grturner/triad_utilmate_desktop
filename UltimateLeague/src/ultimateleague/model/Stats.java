package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Stats implements java.io.Serializable {
    private String mStatsId;
    private String mWins;
    private String mLoss;
    private String mPassingYards;
    private String mPassingCompletions;
    private String mPlayerId;

    public String getStatsId() {
        return mStatsId;
    }

    public void setStatsId(String statsId) {
        mStatsId = statsId;
    }

    public String getWins() {
        return mWins;
    }

    public void setWins(String wins) {
        mWins = wins;
    }

    public String getLoss() {
        return mLoss;
    }

    public void setLoss(String loss) {
        mLoss = loss;
    }

    public String getPassingYards() {
        return mPassingYards;
    }

    public void setPassingYards(String passingYards) {
        mPassingYards = passingYards;
    }

    public String getPassingCompletions() {
        return mPassingCompletions;
    }

    public void setPassingCompletions(String passingCompletions) {
        mPassingCompletions = passingCompletions;
    }

    public String getPlayerId() {
        return mPlayerId;
    }

    public void setPlayerId(String playerId) {
        mPlayerId = playerId;
    }
}
