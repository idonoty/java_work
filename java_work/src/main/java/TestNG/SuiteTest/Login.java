package TestNG.SuiteTest;

import org.testng.annotations.Test;

//和suite.xml文件对应，使用xml文件进行套件测试，具体查看XML文件内容
public class Login {
    @Test
    public void logout(){
        System.out.println("登录成功");
    }
}
