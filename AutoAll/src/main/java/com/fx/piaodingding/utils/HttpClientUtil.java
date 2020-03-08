package com.fx.piaodingding.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.apache.http.client.CookieStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HttpClientUtil {
    private static final CookieStore cookie = new BasicCookieStore();
    public static long allTime;

    /*
    该方法按照请求地址，请求参数和请求头信息的方式传入(U+P+H)
    params按照 key2=value2&key2=value2 的格式
    headers按照 name1=value1;name2=value2 的格式
    例如：pddGet("http://localhost:8080/login?","name=A&id=2","header=a;charset=utf-8")
    */
    public static String Request(String method,String url,String params,String headers){
        if (method.equalsIgnoreCase("get")){
            return Response(method,url+params,null,headers);
        }else {
            return Response(method,url,params,headers);
        }
    }
    //U+P
    public static String Request(String method,String url,String params){
        if (method.equalsIgnoreCase("get")){
            return Response(method,url+params,null,null);
        }else {
            return Response(method,url,params,null);
        }
    }
    //U+H
    public static String Request(String method,String url,Object headers){
        return Response(method,url,null,headers.toString());
    }

    //U
    public static String Request(String method,String url){
        return Response(method,url,null,null);
    }


    private static String Response(String method,String url,String params,String headers){
        HttpRequestBase httprequest;
        HttpEntity httpEntity = null;
        String result=null;
        CloseableHttpClient httpClients = HttpClients.custom().setDefaultCookieStore(cookie).build();
        try {
            if (method.equalsIgnoreCase("get")){
                httprequest=new HttpGet(url);
            }else if (method.equalsIgnoreCase("post")){
                httprequest=new HttpPost(url);
                if (params!=null){
                    // 参数处理，核心是 UrlEncodedFormEntity 需要List<NameValuePair>
                    List<NameValuePair> list = new ArrayList<>();
                    String params_list[]=params.split("&");
                    for(String param : params_list){
                        String values[] = param.split("=");
                        list.add(new BasicNameValuePair(values[0],values[1]));
                    }
                    if (list.size() > 0) {
                        ((HttpPost) httprequest).setEntity(new UrlEncodedFormEntity(list,"utf-8"));
                    }
                }
            }else if(method.equalsIgnoreCase("postJson")){
                httprequest=new HttpPost(url);
                if (params!=null){
                    ((HttpPost) httprequest).setEntity(new StringEntity(params,"utf-8"));
                }
            }else {
                return "请求失败，请求方式必须为\"get\"或\"post\"或\"postJson\"";
            }
            if(headers!=null){
                String headerList[] = headers.split(";");
                for (String header: headerList) {
                    String values[] = header.split("=");
                    httprequest.addHeader(values[0],values[1]);
                }
            }
            long startTime = System.currentTimeMillis();   //获取开始时间
            CloseableHttpResponse Response=httpClients.execute(httprequest);
            if(Response.getStatusLine().getStatusCode()==200){
                allTime = System.currentTimeMillis()-startTime; //计算请求时间，单位毫秒
            }else {
                System.out.println("接口请求失败，code="+Response.getStatusLine().getStatusCode());
            }
            httpEntity =Response.getEntity();
            result=EntityUtils.toString(httpEntity,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                EntityUtils.consume(httpEntity);
                httpClients.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
