package com.example.facebookfake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.facebookfake.fragments.CallFragment;
import com.example.facebookfake.fragments.ChatsFragment;
import com.example.facebookfake.fragments.PeopleFragment;
import com.example.facebookfake.fragments.StoriesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity {
    Toolbar myToolbar;
    DrawerLayout myDrawer;
    NavigationView myNavigation;

    View headerNavigation;

    ImageButton btAvatar, btSetting;
    Button btName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupToolBar();
        setupBottomMenu();
        setupDrawer();
    }

    void setupToolBar(){
        myToolbar = findViewById(R.id.materialToolbarHome);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Chats");
    }

    void setupBottomMenu() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewHome);
        bottomNavigationView.setOnItemSelectedListener(onItemSelectedListener());
        setFragment(new ChatsFragment());
    }

    void setupDrawer() {
        myDrawer  = findViewById(R.id.drawerLayoutHome);
        myNavigation = findViewById(R.id.navigationViewHome);
        myNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int size = myNavigation.getMenu().size();
                for (int i = 0; i < size; i++) {
                    myNavigation.getMenu().getItem(i).setChecked(false);
                }

                if(item.getItemId() == R.id.mnDrawerHomeChat) {
                    // Do Something
                }

                if(item.getItemId() == R.id.mnDrawerHomeLogout) {
                    showConfirmLogOut();
                }
                item.setChecked(true);
                myDrawer.close();
                return true;
            }
        });

        headerNavigation = myNavigation.getHeaderView(0);
        btSetting = headerNavigation.findViewById(R.id.imageButtonSetting);
        btSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, NewChatActivity.class);
                startActivity(i);
            }
        });
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

    void showConfirmLogOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        gotoLoginScreen();
                        finish();
                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        //2. now setup to change color of the button
        alert.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.app_main_bg, null));
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.gray_light, null));
            }
        });
        alert.show();
    }

    void gotoLoginScreen() {
        Intent i = new Intent(HomeActivity.this, SignInActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            myDrawer.open();
        }
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

    @Override
    public void onBackPressed() {
        // do nothing
    }
}

