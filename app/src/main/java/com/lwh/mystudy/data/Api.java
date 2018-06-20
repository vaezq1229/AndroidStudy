package com.lwh.mystudy.data;

import com.lwh.mystudy.model.LoginResponse;
import com.lwh.mystudy.model.RegisterResponse;
import com.lwh.mystudy.request.LoginRequest;
import com.lwh.mystudy.request.RegisterRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by ${lwh} on 2018/6/15.
 *
 * @descirbe
 */
public interface Api {
    @GET
    Observable<LoginResponse> login(@Body LoginRequest request);

    @GET
    Observable<RegisterResponse> register(@Body RegisterRequest request);
}
