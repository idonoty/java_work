package HttpClient.TestNgAndHttpClient;

import WanZheng.java.utils.httpclient.check.CheckPointUtils;
import WanZheng.java.utils.httpclient.check.JsonCheckResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieStore;

public class HttpClient_Post {
    private BasicCookieStore store = new BasicCookieStore();
    @Test
    public void post_getcookies() throws IOException {
        //首先要实例化http请求方法
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
        //然后实例化post方法
        HttpPost post = new HttpPost("http://localhost:8088/postgetcookies");
        //加入post请求参数
        post.setEntity(new StringEntity("{\"username\":\"yyc\",\"password\":\"yyc111\"}","utf-8"));
        //加入头部信息
        //执行请求
        CloseableHttpResponse response = httpClient.execute(post);
        //查看返回结果
        String result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //断言结果
        Assert.assertEquals("post请求的cookie获取成功",result);
        //拿到cookie
        System.out.println(store);
    }

    @Test(dependsOnMethods="post_getcookies")
    public void post_setcookies() throws IOException {
        //首先要实例化http请求方法
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
        //然后实例化post方法
        HttpPost post = new HttpPost("http://localhost:8088/post/login/cookies");
        //加入post请求参数
        post.setEntity(new StringEntity("{\"username\":\"yyc\",\"password\":\"yyc111\"}","utf-8"));
        //加入头部信息
        post.addHeader("content-type","application/json");
        //执行请求
        CloseableHttpResponse response = httpClient.execute(post);
        //查看返回结果
        String result= EntityUtils.toString(response.getEntity(),"utf-8");
        int code =response.getStatusLine().getStatusCode();
        System.out.println(result+code);
        //断言结果用fastjson提取以及断言
        JSONObject jsonObject = JSON.parseObject(result);
        String returnCode = (String) jsonObject.get("text");
        Assert.assertEquals("登录成功",returnCode);
        //用CheckPointUtils枚举类中的校验方法
        JsonCheckResult jsonCheckResult = CheckPointUtils.check(result, "code=200");
        if (jsonCheckResult.toString().equals("SUCCESS")){
            System.out.println(jsonCheckResult.getMsg() + " 判断依据: code=200");
        }else {
            System.out.println("返回值和预期值不匹配");
            throw new ArithmeticException();
        }


    }
}
