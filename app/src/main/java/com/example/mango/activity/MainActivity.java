package com.example.mango.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mango.R;
import com.example.mango.adapter.BottomBarAdapter;
import com.example.mango.customView.NoSwipePager;
import com.example.mango.fragments.CardsListFragment;
import com.example.mango.fragments.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static int CARDS = 0;
    private final static int ME = 1;

    @BindView(R.id.bottom_nav_view)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.main_view_pager)
    NoSwipePager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainViewPager.setPagingEnabled(false);
        BottomBarAdapter pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        //Create fragments for activity here.
        CardsListFragment cardsListFragment = new CardsListFragment();
        ProfileFragment profileFragment = new ProfileFragment();

        pagerAdapter.addFragments(cardsListFragment);
        pagerAdapter.addFragments(profileFragment);


        mainViewPager.setAdapter(pagerAdapter);
        mainViewPager.addOnPageChangeListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.action_card:
                mainViewPager.setCurrentItem(CARDS, true);
                break;
            case R.id.action_scan:
                startActivity(new Intent(MainActivity.this, CameraScanActivity.class));
                break;
            case R.id.action_me:
                mainViewPager.setCurrentItem(ME, true);
                break;

        }
        return true;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case CARDS:
                bottomNavigationView.setSelectedItemId(R.id.action_card);
                break;
            case ME:
                bottomNavigationView.setSelectedItemId(R.id.action_me);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
