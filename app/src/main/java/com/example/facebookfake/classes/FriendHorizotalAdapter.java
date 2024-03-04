package com.example.facebookfake.classes;

import android.content.Context;
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

import java.io.InputStream;
import java.util.ArrayList;

public class FriendHorizotalAdapter extends RecyclerView.Adapter<FriendHorizotalAdapter.FriendViewHolder> {
    ArrayList<Friend> lstFriends;
    Context context;
    FriendClickListener friendClickListener;
    public FriendHorizotalAdapter(ArrayList<Friend> lstFriends, Context context, FriendClickListener friendClickListener) {
        this.lstFriends = lstFriends;
        this.context = context;
        this.friendClickListener = friendClickListener;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.item_chat_horizotal,parent,false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Friend item = lstFriends.get(position);
        holder.textViewName.setText(item.getName());
        holder.imageView.setImageBitmap(Utils.loadBitmapFromAssets(context,item.getAvatar()));
        holder.itemView.setOnClickListener(view -> friendClickListener.onFriendClick(holder.imageView,position));
    }

    @Override
    public int getItemCount() {
        return lstFriends.size();
    }


    class FriendViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;
        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageViewUserAvatar);
        }
    }

    public interface FriendClickListener{
        void onFriendClick(View view, int position);
    }
}
