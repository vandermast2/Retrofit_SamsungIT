package com.breez.retrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.breez.retrofit.R;
import com.breez.retrofit.Service;
import com.breez.retrofit.model.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<DataModel> {
    RecyclerView recyclerView;
    TextView url,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvReceipts);
        url = findViewById(R.id.txtUrl);
        title = findViewById(R.id.txtTitle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        getRecipe();
    }

    private void getRecipe() {
        Call<DataModel> call = Service.getApi().getRecipe();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
        DataModel dataModel = response.body();
        url.setText(dataModel != null ? dataModel.getHref() : null);
        title.setText(dataModel.getTitle());
        RecipeAdapter recipeAdapter = new RecipeAdapter();
        recipeAdapter.setList(dataModel.getResults());
        recyclerView.setAdapter(recipeAdapter);
//        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onFailure(Call<DataModel> call, Throwable t) {

    }
}
