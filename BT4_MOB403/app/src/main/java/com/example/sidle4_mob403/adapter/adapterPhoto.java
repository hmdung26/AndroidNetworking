package com.example.sidle4_mob403.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidle4_mob403.R;
import com.example.sidle4_mob403.model.photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterPhoto extends RecyclerView.Adapter<adapterPhoto.ViewHolder> {

    Context context;
    List<photo> listpt;

    public adapterPhoto(Context context, List<photo> listpt) {
        this.context = context;
        this.listpt = listpt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        photo pt = listpt.get(position);
        holder.tv_title.setText(pt.getTitle());
        holder.tv_id.setText(String.valueOf(pt.getId()));
        Picasso.get().load(pt.getThumbnailUrl()).into(holder.img_photo);
    }

    @Override
    public int getItemCount() {
        return listpt.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id,tv_title;
        ImageView img_photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_photo = itemView.findViewById(R.id.img_photo);
        }
    }
}
