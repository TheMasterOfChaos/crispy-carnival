package com.example.testname.specialClasses;

import com.example.testname.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {
    Response response;
    private Retrofit retrofit;
    public static Api api;
    private static  Server ourInstance;

    public static void getInstance() {
        if (ourInstance == null)
            ourInstance = new Server();
    }

    private Server() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://176.53.160.19/api/") //Базовая часть адреса
                //.baseUrl("http://requestbin.fullcontact.com/1eclwbd1/") //тестовый адрес
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())//Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        api = retrofit.create(Api.class);
    }
}
