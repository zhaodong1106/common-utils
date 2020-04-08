package com.zhaodong.commonutils.utils;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zhaodong
 */
@Component
@ConditionalOnClass(OkHttpClient.class)
public class HttpUtils {

    @Autowired
    private OkHttpClient okHttpClient;

    private  static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    public String get(String url) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.get();
        builder.url(url);
        Request request=builder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url,String token) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.get();
        builder.url(url);
        builder.addHeader("Authorization",token);
        Request request=builder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }


    public String post(String url,String body) throws IOException {
        Request.Builder builder = new Request.Builder();
        RequestBody requestBody= RequestBody.create(MEDIA_TYPE_JSON,body);
        builder.post(requestBody);
        builder.url(url);
        Request request=builder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public String post(String url,String body,String token) throws IOException {
        Request.Builder builder = new Request.Builder();
        RequestBody requestBody= RequestBody.create(MEDIA_TYPE_JSON,body);
        builder.post(requestBody);
        builder.url(url);
        builder.addHeader("Authorization",token);
        Request request=builder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

}
