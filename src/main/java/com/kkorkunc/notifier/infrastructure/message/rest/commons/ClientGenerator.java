package com.kkorkunc.notifier.infrastructure.message.rest.commons;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientGenerator {

    private static final OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass, String baseUrl){
        return getBuilder(baseUrl).client(httpClient.build()).build().create(serviceClass);
    }

    private static Retrofit.Builder getBuilder(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
    }

}