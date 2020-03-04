package First.pers.yyc.SpringBoot.Interface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
这是一个开发get接口请求的类，主要使用的是：
    装请求信息的类 HttpServletRequest
    装返回信息的类 HttpServletResponse
 */

//托管注解
@RestController
//这是生成swagger需要的注解
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    private  String cookieValue=RandomStringUtils.randomAlphanumeric(10);
    //这是一个获取cookies的get接口
    //访问路径和访问方式
    @ApiOperation(value = "拿到cookies的方法",httpMethod = "GET")
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","123");
        response.addCookie(cookie);
        return "cookie获取成功"+cookie.getName()+": "+cookie.getValue();
    }

    //这是一个使用cookies进行请求的get接口
    @RequestMapping(value ="/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "需要cookies的方法",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookie才能访问";
        }
        for(Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("123")){
                return "cookie正确，访问成功";
            }else {
                return "访问失败，cookie错误";
            }
        }
        return "你必须携带cookie才能访问";
    }

    /*
    开发一个携带参数才能访问的get请求
    第一种方法 url： key=value&key=value
    http://localhost:8881/getWithParam?one=0&two=0
     */
    @RequestMapping(value = "/getWithParam",method = RequestMethod.GET)
    @ApiOperation(value = "需要参数的第一种方法",httpMethod = "GET")
    //不限制传入的值
    public Map<String,Integer> getParam(@RequestParam Integer one,@RequestParam Integer two){
        Map<String, Integer> myMap= new HashMap<>();
        myMap.put("鞋子",200);
        myMap.put("衣服",300);
        myMap.put("裤子",400);
        return myMap;
    }

    /*
    第二种方法,主要是注解上的区别，url： ip:port/interface/value/value
    http://localhost:8881/getWithParam2/1/2
     */
    @RequestMapping(value = "/getWithParam2/{one}/{two}")
    @ApiOperation(value = "需要参数的第二种方法",httpMethod = "GET")
    public Map<String,Integer> getParam2(@PathVariable Integer one,@PathVariable Integer two){
        Map<String, Integer> myMap= new HashMap<>();
        myMap.put("鞋子",200);
        myMap.put("衣服",300);
        myMap.put("裤子",400);
        return myMap;
    }
}
