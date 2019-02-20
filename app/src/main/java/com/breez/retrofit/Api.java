package com.breez.retrofit;

import com.breez.retrofit.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("?i=onions")
    public Call<DataModel> getRecipe();
}
