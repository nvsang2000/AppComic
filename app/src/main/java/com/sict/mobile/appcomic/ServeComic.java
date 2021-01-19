package com.sict.mobile.appcomic;

import com.sict.mobile.appcomic.Model.Chapter;
import com.sict.mobile.appcomic.Model.Comic;
import com.sict.mobile.appcomic.Model.SignIn;
import com.sict.mobile.appcomic.Model.SignUp;
import com.sict.mobile.appcomic.Model.TokenUser;
import com.sict.mobile.appcomic.Model.User;
import com.sict.mobile.appcomic.Model.Mess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ServeComic{
    @GET("gettruyen")
    Call<List<Comic>> getComic();
    
    @POST("auth/login")
    Call<TokenUser> login(@Body SignIn loginModel);

    @GET("user-info")
    Call<User> getUserAuth(@Header("Authorization") String token);

    @POST("auth/register")
    Call<Mess> register(@Body SignUp registerModel);

    @GET("getChapter")
    Call<List<Chapter>> getChapter();


}
