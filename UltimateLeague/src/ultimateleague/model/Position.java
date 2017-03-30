package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Position implements java.io.Serializable {
    private String mPositionId;
    private String mExperienceName;
    private String mPositionName;

    public String getPositionId() {
        return mPositionId;
    }

    public void setPositionId(String positionId) {
        mPositionId = positionId;
    }

    public String getExperienceName() {
        return mExperienceName;
    }

    public void setExperienceName(String experienceName) {
        mExperienceName = experienceName;
    }

    public String getPositionName() {
        return mPositionName;
    }

    public void setPositionName(String positionName) {
        mPositionName = positionName;
    }
}
