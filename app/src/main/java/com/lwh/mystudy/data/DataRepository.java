package com.lwh.mystudy.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${lwh} on 2018/6/15.
 *
 * @descirbe
 */
public class DataRepository {

    private Api mApi;

    private DataRepository(){
        init();
    }

    private void init() {
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder()
                        .addHeader("Client-Type", "android")
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(new MyHttpLoggingInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .callFactory(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApi = retrofit.create(Api.class);
    }
}
