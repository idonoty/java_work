import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
写好测试方法后，使用xml文件运行并生成报告
 */
public class Extend_Demo {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals("abc","cba");
    }

    @Test
    public void test3(){
        Assert.assertEquals("qqq","qqq");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是自己写的日志");
        throw new RuntimeException("自己抛出的运行异常");
    }
}
