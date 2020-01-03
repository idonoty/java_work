package Testng_HTTPclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpClientUtils {
    public static String doPost(String url, String interFace, String params,String headers) {
        String result=null;
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url + interFace);
        if (headers != null) {
            String[] header_array = headers.split(";");
            for (String header : header_array) {
                String[] key_array = header.split("=");
                if(key_array.length>1) {
                    httpPost.addHeader(key_array[0], key_array[1]);
                }
            }
        }
        try {
            httpPost.setEntity(new StringEntity(params,"utf-8"));
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            result= EntityUtils.toString(httpEntity,"utf-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String doGet(String url, String interFace, String params) {
        String result=null;
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url + interFace+params);

        try {
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            result= EntityUtils.toString(httpEntity,"utf-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(doGet("http://api.codai.vip/","login.json?","username=yyc1&password=yyc111&device=30"));
        System.out.println(doPost("http://192.168.1.53:3000/","ctrip/flightSearch?","[{\"foreign=false},{\"dtime\":\"2019-07-17\",\"accode\":\"HGH\",\"dccode\":\"CSX\",\"foreign\":false}]","content-type=application/json;accept-encoding=gzip"));
    }
}
