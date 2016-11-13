package com.example.sth0409.rxjava_retrofit;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.observables.AndroidObservable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    private String baseUrl="https://api.douban.com/v2/movie/";
    private String TAG="--------";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MovieService movieService=retrofit.create(MovieService.class);
        movieService.getTopMovie(1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onNext: "+2);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                Log.i(TAG, "onNext: "+1+movieEntity.getSubjects().get(0).getTitle().toString());

            }
        });



    }
}
