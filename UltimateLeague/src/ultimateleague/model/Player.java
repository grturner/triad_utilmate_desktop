package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Player implements java.io.Serializable {
    private String mPlayerId;
    private String mCaptainId;
    private String mFirstName;
    private String mLastName;
    private String mStreetAddr;
    private String mCity;
    private String mState;
    private String mZip;
    private String mEmail;
    private String mPhone;
    private String mTeamId;
    private String mShirtSize;
    private String mBirthDate;
    private String mVertStack;
    private String mHorizStack;
    private String mZone;

    public String getPlayerId() {
        return mPlayerId;
    }

    public void setPlayerId(String playerId) {
        mPlayerId = playerId;
    }

    public String getCaptainId() {
        return mCaptainId;
    }

    public void setCaptainId(String captainId) {
        mCaptainId = captainId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getStreetAddr() {
        return mStreetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        mStreetAddr = streetAddr;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getZip() {
        return mZip;
    }

    public void setZip(String zip) {
        mZip = zip;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getTeamId() {
        return mTeamId;
    }

    public void setTeamId(String teamId) {
        mTeamId = teamId;
    }

    public String getShirtSize() {
        return mShirtSize;
    }

    public void setShirtSize(String shirtSize) {
        mShirtSize = shirtSize;
    }

    public String getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(String birthDate) {
        mBirthDate = birthDate;
    }

    public String getVertStack() {
        return mVertStack;
    }

    public void setVertStack(String vertStack) {
        mVertStack = vertStack;
    }

    public String getHorizStack() {
        return mHorizStack;
    }

    public void setHorizStack(String horizStack) {
        mHorizStack = horizStack;
    }

    public String getZone() {
        return mZone;
    }

    public void setZone(String zone) {
        mZone = zone;
    }
}
