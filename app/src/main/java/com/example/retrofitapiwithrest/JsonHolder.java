package com.example.retrofitapiwithrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonHolder {


    //get post is defining the data is about to send/request type.
   // @GET("posts")
   // Call<List<Post>> getPosts();
    //calling method in and requesting data in list format.
    //this is the beauty of Retrofit that we dont need to write unnecessary network code to set up connection.
    // call object encapsulate single get request and response.



    //filtering data on the basis of user id and dealing with relative URL end points.
    //@GET("posts")
    //Call<List<Post>> getPosts(@Query("userId")int userId);
    //Call<List<Post>> getPosts();


    //dealing with multiple queries.
    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId")int userId,
                              @Query("_sort")String sort,
                              @Query("_order")String order);
    Call<List<Post>> getPosts();


    //different type of requests with specific id and  comment type.
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);
}
