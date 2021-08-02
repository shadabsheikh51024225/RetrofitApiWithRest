package com.example.retrofitapiwithrest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

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


    //requesting data in query map formate with key and value pairs.
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    //different type of requests with specific id and  comment type.
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    //when structure is quite complicated and you would like to deal with whole url.
    @GET
    Call<List<Comment>> getComments(@Url String url);


    //replacing operation with respected id and also replacing body.
    //put is used to completely update any resource requested.
   // @PUT("posts/{id}")
   // Call<Post> putPost(@Path("id") int id, @Body Post post);


    //here we are defining headers for our requests.
    @Headers({"Static-Header1: 123", "Static-Header2: 456"})
    @PUT("posts/{id}")
    Call<Post> putPost(@Header("Dynamic-Header") String header,
                       @Path("id") int id,
                       @Body Post post);

    //patch is used to only update a respected field of requested resource.
    //@PATCH("posts/{id}")
   // Call<Post> patchPost(@Path("id") int id, @Body Post post);

    //using patch with headers.
    @PATCH("posts/{id}")
    Call<Post> patchPost(@HeaderMap Map<String, String> headers,
                         @Path("id") int id,
                         @Body Post post);


    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
