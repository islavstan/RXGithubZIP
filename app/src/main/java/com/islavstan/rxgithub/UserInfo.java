package com.islavstan.rxgithub;

import com.google.gson.annotations.SerializedName;



public class UserInfo {
    @SerializedName("login")
    String login;
    @SerializedName("email")
    String email;
    @SerializedName("public_repos")
    String public_repos;
    @SerializedName("public_gists")
    String public_gists;

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public String getPublic_gists() {
        return public_gists;
    }
}
