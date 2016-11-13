package com.example.sth0409.rxjava_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    String baseUrl = "http://route.showapi.com/";
    public static final String URL_lIST="http://route.showapi.com/958-1";
    public static final String URL_BOOT="http://heibaimanhua.com";
    //showapi_appid
    public static final String showapi_appid="19236";
    //showapi_sign
    public static final String showapi_sign="5980ab887ee247a6aa0bd4c0734f6481";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //增加返回值为String的支持
              .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
               // .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        PostService requestSerives = retrofit.create(PostService.class);//这里采用的是Java的动态代理模式
        Call<String> entityCall=requestSerives.addReviews(showapi_appid,showapi_sign,"type=/category/mengchong","1");
        entityCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("-----", "onResponse: "+response.body().toString());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
