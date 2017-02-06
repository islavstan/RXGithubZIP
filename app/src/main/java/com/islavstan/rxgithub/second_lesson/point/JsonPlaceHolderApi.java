package com.islavstan.rxgithub.second_lesson.point;

import com.islavstan.rxgithub.second_lesson.model.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;



public interface JsonPlaceHolderApi {
    @GET("posts")
    Observable<List<Post>> getPosts();
}