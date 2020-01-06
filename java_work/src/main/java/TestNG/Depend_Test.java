package TestNG;

import org.testng.annotations.Test;
/*
依赖性测试,一般作为方法前必须执行的方法
 */
public class Depend_Test {
    @Test
    public void depend1(){
        System.out.println("这是被依赖的方法");
        //若被依赖的方法执行失败，则依赖的方法会被忽略执行
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"depend1"})
    public void depend2(){
        System.out.println("这是声明了依赖的方法");
    }
}
