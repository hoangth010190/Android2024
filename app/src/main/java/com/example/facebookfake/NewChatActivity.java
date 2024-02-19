package com.example.facebookfake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import com.example.facebookfake.fragments.CallFragment;
import com.example.facebookfake.fragments.ChatsFragment;
import com.example.facebookfake.fragments.PeopleFragment;
import com.example.facebookfake.fragments.StoriesFragment;
import com.google.android.material.tabs.TabLayout;


public class NewChatActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chat);

        tabLayout = findViewById(R.id.tabLayout);
        toolbar = findViewById(R.id.materialToolbar);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    setFragment(new ChatsFragment());
                }

                if (tab.getPosition() == 1) {
                    setFragment(new CallFragment());
                }

                if (tab.getPosition() == 2) {
                    setFragment(new StoriesFragment());
                }

                if (tab.getPosition() == 3) {
                    setFragment(new PeopleFragment());
                }

                if (tab.getPosition() == 4) {
                    setFragment(new StoriesFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    void setFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView2, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}