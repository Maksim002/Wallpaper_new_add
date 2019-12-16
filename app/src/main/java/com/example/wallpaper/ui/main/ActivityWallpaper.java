package com.example.wallpaper.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.wallpaper.R;
import com.example.wallpaper.ui.adapter.pager.ViewPegerAdaptor;
import com.example.wallpaper.ui.main.password.ActivityPassword;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityWallpaper extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        toolbar = findViewById(R.id.toolWallpaper);
        toolbar.setTitle("Wallpaper");
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager();
        setupNavigationView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_passvord,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.password:
                Intent intent = new Intent(this, ActivityPassword.class);
                startActivity(intent);
                break;
        }
        return false;
    }

    private void setupNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.winter:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.nature:
                                viewPager.setCurrentItem(1);
                                return true;
                            case R.id.other:
                                viewPager.setCurrentItem(2);
                                return true;
                            case R.id.new_year:
                                viewPager.setCurrentItem(3);
                                return true;
                            case R.id.state:
                                viewPager.setCurrentItem(4);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setupViewPager(){
        ViewPegerAdaptor adaptor = new ViewPegerAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new WinterFragment());
        adaptor.addFragment(new NatureFragment());
        adaptor.addFragment(new OtherFragment());
        adaptor.addFragment(new NewYearFragment());
        adaptor.addFragment(new StateFragment());
        viewPager.setAdapter(adaptor);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.winter);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.nature);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.other);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.new_year);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.state);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
