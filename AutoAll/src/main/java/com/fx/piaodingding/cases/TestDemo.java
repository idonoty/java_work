package com.fx.piaodingding.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.fx.piaodingding.utils.HttpClientUtil.Request;
import static com.fx.piaodingding.utils.HttpClientUtil.allTime;


public class TestDemo{
    private String url="http://localhost:8881";
    @Test
    public void get1(){
        String result=Request("get",url+"/getCookies");
        System.out.println(result);
    }

    @Test(dependsOnMethods = "get1")
    public void get2(){
        String result=Request("get",url+"/getWithCookies");
        System.out.println(result);
    }

    @Test
    public void post1(){
        String result=Request("pOSt",url+"/v1/post/getCookies","username=yyc&password=yyc111");
        System.out.println(result);
    }

    @Test(dependsOnMethods = "post1")
    public void post2(){
        String result=Request("POSTJSon",url+"/v1/post/getUserList",
                "{\"username\":\"yyc\",\"password\":\"yyc111\"}",
                "content-type=application/json");
        JSONObject jsonObject = JSON.parseObject(result);
        String returnText = jsonObject.getString("name");
        System.out.println(returnText);
        Assert.assertEquals(returnText,"张三");
        System.out.println(allTime+"ms\n"+result);
    }
}
