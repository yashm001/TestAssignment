package com.example.testassignment.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testassignment.R;
import com.example.testassignment.model.TypeB;

import org.w3c.dom.Text;

import java.util.List;

public class Type1Adapter extends RecyclerView.Adapter<Type1Adapter.ViewHolder> {

    Context ctx;
    private List<TypeB> movies;

    public Type1Adapter(Context ctx, List<TypeB> movies) {
        this.ctx = ctx;
        this.movies = movies;
    }

    @NonNull
    @Override
    public Type1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.card1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Type1Adapter.ViewHolder holder, int position) {

        holder.title.setText(movies.get(position).getTitle());
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.card1Image);
            title = itemView.findViewById(R.id.card1Title);
        }
    }
}
