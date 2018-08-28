package com.example.deepakrattan.navigationdrawerwithnavigationviewdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        /*The ActionBarDrawerToggle is used with a DrawerLayout to implement the
        recommended functionality of Navigation Drawers. It has the following usages:
        It acts as a listener, for opening and closing of drawers.
        It provides the hamburger icons in the ToolBar/ActionBar.
        It’s allows for the animation between the hamburger icon and the arrow to exist.
*/
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        //To add a listener on the DrawerLayout the following method is used.
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = (String) item.getTitle();
                setTitle(title);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                        fragment = new HomeFragment();
                        fragmentTransaction.replace(R.id.contentFrame, fragment);
                        fragmentTransaction.commit();
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                        // close drawer when item is tapped
                        fragment = new ProfileFragment();
                        fragmentTransaction.replace(R.id.contentFrame, fragment);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.setting:
                        Toast.makeText(MainActivity.this, "Setting is clicked", Toast.LENGTH_SHORT).show();
                        // close drawer when item is tapped
                        fragment = new SettingFragment();
                        fragmentTransaction.replace(R.id.contentFrame, fragment);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }
}
