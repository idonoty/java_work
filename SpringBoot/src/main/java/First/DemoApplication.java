package First;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//进行官方demo启动
@Controller
@EnableAutoConfiguration
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello springboot";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }

}