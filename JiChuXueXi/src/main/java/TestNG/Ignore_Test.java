package TestNG;

import org.testng.annotations.Test;

public class Ignore_Test {
    @Test
    public void ignore1(){
        System.out.println("忽略测试1-不忽略");
    }

    @Test(enabled=false)
    public void ignore2(){
        System.out.println("忽略测试2-忽略");
    }

    //不填写enabled属性时，默认为true
    @Test(enabled=true)
    public void ignore3(){
        System.out.println("忽略测试3-不忽略");
    }
}
