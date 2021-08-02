package com.example.retrofitapiwithrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonHolder {


    //get post is defining the data is about to send/request type.
    @GET("posts")
    Call<List<Post>> getPosts();
    //calling method in and requesting data in list format.
    //this is the beauty of Retrofit that we dont need to write unnecessary network code to set up connection.
    // call object encapsulate single get request and response.

    //different type of requests with specific id and  comment type.
    @GET("posts/2/comments")
    Call<List<Comment>> getComments();
}
