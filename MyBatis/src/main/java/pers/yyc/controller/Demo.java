package pers.yyc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/one",description = "第一个mybatis的Demo")
@RequestMapping(value = "/one")
public class Demo {
    //首先获取一个执行sql语句的对象

    //启动器加载注解
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ApiOperation(value="/获取用户数",httpMethod = "GET")
    public int getUserList(){
        return template.selectOne("GetUserList");
    }
}
