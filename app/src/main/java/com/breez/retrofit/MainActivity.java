package com.breez.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.breez.retrofit.model.DataModel;
import com.breez.retrofit.model.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements Callback<DataModel>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRecipe();
    }

    private void getRecipe(){
        Call<Object> call = Service.getApi().getRecipe();
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                response.body().toString();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
t.getMessage();
            }
        });
    }


    @Override
    public void onResponse(Call call, Response response) {
        response.body();
    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
