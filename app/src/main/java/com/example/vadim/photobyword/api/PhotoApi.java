package com.example.vadim.photobyword.api;

import com.example.vadim.photobyword.pojo.ResponsePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PhotoApi {

    String ENDPOINT = "https://api.gettyimages.com/";

    @Headers("Api-Key:zy88nrsu65mk8gvyhsgd5y8e")
    @GET("/v3/search/images")
    Call<ResponsePojo> searchPhoto(
            @Query("ﬁelds") String ﬁelds,
            @Query("sort_order") String sort_order,
            @Query("phrase") String phrase);
}
