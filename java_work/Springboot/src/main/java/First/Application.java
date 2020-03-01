package First;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//使用SpBt托管
@SpringBootApplication
//需要执行的包（启动这里面的接口和swagger配置）
@ComponentScan("First.pers.yyc")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
