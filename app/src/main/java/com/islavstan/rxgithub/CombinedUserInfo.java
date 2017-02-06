package com.islavstan.rxgithub;

/**
 * Created by islav on 06.02.2017.
 */

public class CombinedUserInfo {
    UserInfo userInfo;
    UserInfo2 userInfo2;

    public CombinedUserInfo(UserInfo userInfo, UserInfo2 userInfo2) {
        this.userInfo = userInfo;
        this.userInfo2 = userInfo2;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo2 getUserInfo2() {
        return userInfo2;
    }

    public void setUserInfo2(UserInfo2 userInfo2) {
        this.userInfo2 = userInfo2;
    }
}
