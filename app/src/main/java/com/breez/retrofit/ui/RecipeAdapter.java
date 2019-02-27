package com.breez.retrofit.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.breez.retrofit.R;
import com.breez.retrofit.model.Result;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<Result> list;
    public void setList(List<Result> list){
        this.list =list;
        notifyDataSetChanged();
    }

    public RecipeAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.container,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    public RecipeAdapter(List<Result> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtUrl,txtTitle,txtIngredients;
        private  ImageView imfPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imfPhoto = itemView.findViewById(R.id.imageView);
            txtIngredients = itemView.findViewById(R.id.txtIngredients);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtUrl = itemView.findViewById(R.id.txtUrl);
        }

        public void bind(Result dataModel) {
            Glide.with(imfPhoto.getContext()).load(dataModel.getThumbnail()).into(imfPhoto);
            txtUrl.setText(dataModel.getHref());
            txtTitle.setText(dataModel.getTitle());
            txtIngredients.setText(dataModel.getIngredients());
        }
    }
}
