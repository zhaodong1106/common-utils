package com.zhaodong.commonutils.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnClass(OkHttpClient.class)
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectionPool(new ConnectionPool(10, 10, TimeUnit.SECONDS));
        OkHttpClient okHttpClient = builder.build();
        return okHttpClient;
    }
}
