package com.islavstan.rxgithub;

import com.google.gson.JsonArray;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface Points {


    public interface GitHubUser {
        @GET("users/{user}")
        Observable<UserInfo> getUser(@Path("user") String user);
    }

    public interface GitHubUser2 {
        @GET("users/{user}")
        Observable<UserInfo2> getUser(@Path("user") String user);
    }
}
