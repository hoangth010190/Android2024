package com.example.facebookfake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.facebookfake.classes.Friend;
import com.example.facebookfake.classes.FriendVerticalAdapter;
import com.example.facebookfake.classes.Utils;

public class DetailChatActivity extends AppCompatActivity {
    Friend friendItem;
    Toolbar myToolBar;
ImageView imageView;
TextView textViewName, textViewDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_chat);

        myToolBar = findViewById(R.id.materialToolbarChatDetail);
        textViewName = findViewById(R.id.textViewUserName);
        textViewDes = findViewById(R.id.textViewDesciptions);
        imageView = findViewById(R.id.imageViewAvatar);
        setSupportActionBar(myToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        myToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                finish();
//                return true;
//            }
//        });

        Intent intent = getIntent();
        friendItem = intent.getParcelableExtra("data_detail_key_name");

        myToolBar.setTitle(friendItem.getId());
        textViewName.setText(friendItem.getName());
        textViewDes.setText(friendItem.getDescription());
        imageView.setImageBitmap(Utils.loadBitmapFromAssets(this,friendItem.getAvatar()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}