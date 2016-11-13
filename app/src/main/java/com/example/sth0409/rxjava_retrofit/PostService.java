package com.example.sth0409.rxjava_retrofit;

import retrofit.Callback;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by STH0409 on 2016/11/6.
 */

public interface PostService {
    @FormUrlEncoded
    @POST("958-1")
    Call<String> addReviews(@Field("showapi_appid") String showapi_appid,
                                    @Field("showapi_sign") String showapi_sign,
                                    @Field("type") String type,
                                    @Field("page") String page);
}
