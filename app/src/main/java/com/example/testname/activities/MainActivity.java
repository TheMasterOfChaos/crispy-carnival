package com.example.testname.activities;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.testname.R;
import com.example.testname.fragments.CompletedOrdersFragment;
import com.example.testname.fragments.CurrentOrderFragment;
import com.example.testname.fragments.MyOrdersFragment;
import com.example.testname.fragments.OffersFragment;


public class MainActivity extends AppCompatActivity {

    final Fragment offersFragment = new OffersFragment();
    final Fragment myOrdersFragment = new MyOrdersFragment();
    final Fragment currentOrderFragment = new CurrentOrderFragment();
    final Fragment completedOrdersFragment = new CompletedOrdersFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = offersFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView mainNavigationView = findViewById(R.id.main_navigation_view);

        fm.beginTransaction().add(R.id.main_container, currentOrderFragment, "3")
                .hide(currentOrderFragment).commit();
        fm.beginTransaction().add(R.id.main_container, completedOrdersFragment, "3")
                .hide(completedOrdersFragment).commit();
        fm.beginTransaction().add(R.id.main_container, myOrdersFragment, "2")
                .hide(myOrdersFragment).commit();
        fm.beginTransaction().add(R.id.main_container, offersFragment, "1").commit();



        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
                menuItem -> {
                    switch (menuItem.getItemId()){
                        case R.id.offersItem:
                            fm.beginTransaction().hide(active).show(offersFragment).commit();
                            active = offersFragment;
                            return true;

                        case R.id.myOrdersItem:
                            fm.beginTransaction().hide(active).show(myOrdersFragment).commit();
                            active = myOrdersFragment;
                            return true;
                        case R.id.currentOrderItem:
                            fm.beginTransaction().hide(active).show(currentOrderFragment).commit();
                            active = currentOrderFragment;
                            return true;
                        case R.id.completedOrdersItem:
                            fm.beginTransaction().hide(active).show(completedOrdersFragment).commit();
                            active = completedOrdersFragment;
                            return true;
                    }
                    return false;
                };
        mainNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }


    @Override
    public void onBackPressed() {
    }

    public void logout(View view) {
    }


}
