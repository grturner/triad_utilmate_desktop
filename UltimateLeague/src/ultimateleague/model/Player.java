package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Player implements Comparable<Player> {
    private String mPlayerId;
    private String mCaptainId;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mPhone;
    private String mTeamId;
    private String mShirtSize;
    private String mBirthDate;
    private int mSkill;

    @Override
    public int compareTo(Player p) {
        return new Integer(this.getSkill()).compareTo(p.getSkill());
    }

    public int getSkill() {
        return mSkill;
    }

    public void setSkill(int skill) {
        mSkill = skill;
    }

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

    public String toString(){
        return "Player.class - " + mLastName + ", " + mFirstName + " | Skill: " + mSkill;
    }

}

