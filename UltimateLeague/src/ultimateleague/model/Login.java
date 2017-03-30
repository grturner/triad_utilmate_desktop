package ultimateleague.model;

/**
 * Created by grturner on 3/29/2017.
 */
public class Login implements java.io.Serializable {
    private String mLoginId;
    private String mUserName;
    private String mPlayerId;

    public String getLoginId() {
        return mLoginId;
    }

    public void setLoginId(String loginId) {
        mLoginId = loginId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPlayerId() {
        return mPlayerId;
    }

    public void setPlayerId(String playerId) {
        mPlayerId = playerId;
    }
}
