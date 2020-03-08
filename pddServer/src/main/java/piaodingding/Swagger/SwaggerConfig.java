package piaodingding.Swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//SpringBoot中专门用于加载配置文件的标签
@Configuration
//声明标签为Swagger
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                // 选择那些路径和api会生成document
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                //不显示错误路径的接口
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                // 对根下所有路径进行监控
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    //ApiInfo里写文档标题，联系人信息，描述和版本号
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("yyc接口文档")
                .contact(new Contact("yyc","","389885071@qq.com"))
                .description("这是我的SwaggerUI生成的接口文档")
                .version("1.0.0.0")
                .build();
    }
}
