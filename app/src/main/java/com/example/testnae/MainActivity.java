package com.example.testnae;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkAuthStatus();
        setContentView(R.layout.activity_main);
        BottomNavigationView mainNavigationView = findViewById(R.id.main_navigation_view);
        mainNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                /*switch (menuItem){
                    case findViewById()
                }*/
                return false;
            }
        });
    }

    private void checkAuthStatus() {
        //TODO проверка статуса аутинтификации, и запуск активности для аутинтификации
    }


    public void logout(View view) {
    }
}
