package com.example.testnae;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.testnae.specialClasses.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    final Fragment offersFragment = new OffersFragment();
    final Fragment myOrdersFragment = new MyOrdersFragment();
    //final Fragment fragment3 = new NotificationsFragment();
    //final Fragment fragment3 = new NotificationsFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = offersFragment;

    Response response;
    private Retrofit retrofit;
    private static Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkAuthStatus();
        setContentView(R.layout.activity_main);
        BottomNavigationView mainNavigationView = findViewById(R.id.main_navigation_view);

        /*retrofit = new Retrofit.Builder()
                .baseUrl("http://176.53.160.19/api/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        api = retrofit.create(Api.class);
        getApi().getOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                Log.wtf("TAG", "onCreate: " + response.body().get(0).getId());            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/



        //fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, myOrdersFragment, "2")
                .hide(myOrdersFragment).commit();
        fm.beginTransaction().add(R.id.main_container, offersFragment, "1").commit();



        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.offersItem:
                                fm.beginTransaction().hide(active).show(offersFragment).commit();
                                active = offersFragment;
                                return true;

                            case R.id.myOrdersItem:
                                fm.beginTransaction().hide(active).show(myOrdersFragment).commit();
                                active = myOrdersFragment;
                                return true;

                        }
                        return false;
                    }
                };
        mainNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private void checkAuthStatus() {
        //TODO проверка статуса аутинтификации, и запуск активности для аутинтификации
    }


    public void logout(View view) {
    }


    public static Api getApi(){
        return api;
    }
}
