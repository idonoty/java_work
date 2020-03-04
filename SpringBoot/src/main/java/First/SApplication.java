package First;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//使用SpBt托管
@SpringBootApplication
//需要执行的包（启动这里面的接口和swagger配置）
@ComponentScan("First.pers.yyc")
public class SApplication {
    public static void main(String[] args){
        SpringApplication.run(SApplication.class,args);
    }
}
