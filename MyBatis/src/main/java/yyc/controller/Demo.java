package yyc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import yyc.model.User;

@RestController
@Api(value = "/one",description = "第一个mybatis的Demo")
@RequestMapping(value = "/one")
public class Demo {
    //首先获取一个执行sql语句的对象

    //启动器加载注解
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/GetUserList",method = RequestMethod.GET)
    @ApiOperation(value="/获取用户数",httpMethod = "GET")
    public int getUserList(){
        return template.selectOne("GetUserList");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value="/添加用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        int maxId=template.selectOne("getMaxId");
        user.setId(maxId+1);
        return template.insert("addUser",user);


    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value="/修改id最大的用户信息",httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        int maxId=template.selectOne("getMaxId");
        user.setId(maxId);
        return template.update("updateUser",user);
    }

    @RequestMapping(value="deleteUser",method = RequestMethod.GET)
    @ApiOperation(value="删除联系人",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }

}
