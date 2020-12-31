package com.example.testassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testassignment.R;
import com.example.testassignment.model.TypeB;

import java.util.List;

public class Type2Adapter extends RecyclerView.Adapter<Type2Adapter.ViewHolder> {

    Context ctx;
    private List<TypeB> movies;

    public Type2Adapter(Context ctx, List<TypeB> movies) {
        this.ctx = ctx;
        this.movies = movies;
    }
    @NonNull
    @Override
    public Type2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.card2, parent, false);
        return new Type2Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Type2Adapter.ViewHolder holder, int position) {
        holder.title.setText(movies.get(position).getTitle());
        holder.subtitle.setText(movies.get(position).getSub_title());
        Glide.with(ctx)
                .load(this.movies.get(position).getImg_src())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(movies!=null) {
            return movies.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView subtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.card2Image);
            title = itemView.findViewById(R.id.card2Title);
            subtitle = itemView.findViewById(R.id.card2Subtitle);
        }
    }
}
