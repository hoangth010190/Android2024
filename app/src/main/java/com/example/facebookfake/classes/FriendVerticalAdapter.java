package com.example.facebookfake.classes;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookfake.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FriendVerticalAdapter extends RecyclerView.Adapter<FriendVerticalAdapter.FriendViewHolder> {
    ArrayList<Friend> lstFriends;
    Context context;

    FriendClickListener friendClickListener;
    public FriendVerticalAdapter(ArrayList<Friend> lstFriends, Context context, FriendClickListener friendClickListener) {
        this.lstFriends = lstFriends;
        this.context = context;
        this.friendClickListener = friendClickListener;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.item_chat_vertical,parent,false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Friend item = lstFriends.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewDes.setText(item.getDescription());
        holder.imageView.setImageBitmap(Utils.loadBitmapFromAssets(context,item.getAvatar()));
        holder.itemView.setOnClickListener(view -> friendClickListener.onFriendClick(holder.itemView,position));
    }

    @Override
    public int getItemCount() {
        return lstFriends.size();
    }


    class FriendViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewDes;
        ImageView imageView;
        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDes = itemView.findViewById(R.id.textViewDes);
            imageView = itemView.findViewById(R.id.imageViewUserAvatar);
        }
    }

    public interface FriendClickListener{
        void onFriendClick(View view, int position);
    }
}
