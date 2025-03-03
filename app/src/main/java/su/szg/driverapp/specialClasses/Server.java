package su.szg.driverapp.specialClasses;


import su.szg.driverapp.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {
	private Retrofit retrofit;
	public static Api api;
	public static String token;
	private static  Server ourInstance;
	public static int id;
	public static int driverID;
	
	
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
			.baseUrl("https://lk.szg.su/api/") //Базовая часть адрес
			//.baseUrl("http://176.53.160.19/api/") //Тестовый сервер
			.addConverterFactory(GsonConverterFactory.create())
			.client(client.build())//Конвертер, необходимый для преобразования JSON'а в объекты
			.build();
		api = retrofit.create(Api.class);
	}
}
