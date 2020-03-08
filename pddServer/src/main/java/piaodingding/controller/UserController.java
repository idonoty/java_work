package piaodingding.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import piaodingding.userModell.User;

@RestController
@Api(value = "/user",description = "yyc的票盯盯用户接口")
public class UserController {

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(@RequestBody User user){
        return "";
    }
}
