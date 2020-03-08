package First.pers.yyc.SpringBoot.Interface;


import First.pers.yyc.SpringBoot.Interface.Bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我的全部post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    private  String cookieValue=RandomStringUtils.randomAlphanumeric(20);

    @RequestMapping(value = "/post/getCookies",method = RequestMethod.POST)
    @ApiOperation(value="登录获取cookies的接口",httpMethod = "POST")
    //可在参数后制定参数名和是否必填，默认是必填
    public String postGetCookies(HttpServletResponse response,
                                 @RequestParam(value = "username",required = false) String username,
                                 @RequestParam(value = "password",required = true)  String password){
        if (username.equals("yyc") && password.equals("yyc111")){
            Cookie cookies = new Cookie("login","123");
            response.addCookie(cookies);
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    @RequestMapping(value = "/post/getUserList",method = RequestMethod.POST)
    @ApiOperation(value="获取用户信息",httpMethod = "POST")
    //当你使用的是数组格式时，必须添加请求头：Content-Type = application/json 将数组转换成json
    public String postGetUserList(HttpServletRequest request,
                                @RequestBody User u){
        User user ;
        Cookie[] cookies=request.getCookies();
        //这里一定要确定cookie为空时的返回
        if (Objects.isNull(cookies)){
            return "无cookie";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    &&cookie.getValue().equals("123")
                    &&u.getUsername().equals("yyc")
                    &&u.getPassword().equals("yyc111")){
                //没有new就会报空指针异常
                user =new User();
                user.setAge(20);
                user.setName("张三");
                user.setSex("男");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
