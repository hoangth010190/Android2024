package com.example.facebookfake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.facebookfake.fragments.CallFragment;
import com.example.facebookfake.fragments.ChatsFragment;
import com.example.facebookfake.fragments.PeopleFragment;
import com.example.facebookfake.fragments.StoriesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class HomeActivity extends AppCompatActivity {
    Toolbar myToolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myToolbar = findViewById(R.id.materialToolbarHome);
        setSupportActionBar(myToolbar);

        myToolbar.setTitle("Chats");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewHome);
        bottomNavigationView.setOnItemSelectedListener(onItemSelectedListener());
        setFragment(new ChatsFragment());
    }

    void setFragment(Fragment newFragment) {
        // Create new fragment and transaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack if needed
        transaction.replace(R.id.fragmentContainerView, newFragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnItemNewMessage) {
            Intent i = new Intent(HomeActivity.this, NewChatActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private NavigationBarView.OnItemSelectedListener onItemSelectedListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.bottomItemChat) {
                    setFragment(new ChatsFragment());
                    myToolbar.setTitle("Chats");
                }
                if(item.getItemId() == R.id.bottomItemCall) {
                    setFragment(new CallFragment());
                    myToolbar.setTitle("Calls");
                }
                if(item.getItemId() == R.id.bottomItemPeople) {
                    setFragment(new PeopleFragment());
                    myToolbar.setTitle("People");
                }
                if(item.getItemId() == R.id.bottomItemStories) {
                    setFragment(new StoriesFragment());
                    myToolbar.setTitle("Stories");
                }
                return true;
            }
        };
    }
}

