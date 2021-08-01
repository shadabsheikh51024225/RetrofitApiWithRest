package com.example.retrofitapiwithrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonHolder {


    //get post is defining the data is about to send/request type.
    @GET("posts")
    Call<List<Post>> getPosts();
    //calling method in and requesting data in list format.
    //this is the beauty of Retrofit that we dont need to write unnecessary network code to set up connection.
    // call object encapsulate single get request and response.


}
