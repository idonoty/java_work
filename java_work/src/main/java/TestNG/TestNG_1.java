package TestNG;

import org.testng.annotations.*;
//鼠标处于@Test方法中时，会执行单个@Test方法，若不处于@Test方法则会执行所有方法
public class TestNG_1 {
    @Test(groups = "group1")
        //"group1" 格式严谨，中间多一个空格都不行
    void TEST1() {
        System.out.println("Test1");
    }

    @Test(groups = "group1",expectedExceptions = ArithmeticException.class) //写好会抛出的异常，当出现该异常时，忽略该方法并通过测试,没出现异常就报错。
    void TEST2() {
        System.out.println("Test2");
        int i = 100/0;
        System.out.println(i);
    }

    @Test(groups = "group2")
    void TEST3() {
        System.out.println("test3");
    }

    @BeforeTest
    void 第二() {
        System.out.println("第 2 BeforeTest 所有测试方法运行之前运行");
    }

    @AfterTest
    void 第三() {
        System.out.println("第 3 AfterTest 所有测试方法运行之后运行");
    }

    @BeforeClass
    void 第四() {
        System.out.println("第 4 BeforeClass 在调用当前类的第一个测试方法之前运行");
    }

    @AfterClass
    void 第五() {
        System.out.println("第 5 AfterClass 在调用当前类的第一个测试方法之后运行");
    }

    @BeforeSuite
    void 第六() {
        System.out.println("/n第 6 BeforeSuite 在Test框架最开始运行");
    }

    @AfterSuite
    void 第七() {
        System.out.println("第 7 AfterSuite 在Test框架最后运行");
    }

    @BeforeGroups(groups = "group1")
    void 第八() {
        System.out.println("第 8 BeforeGroups 有对应组方法的时候运行，运行在所有组方法之前");
    }

    @AfterGroups(groups = "group1")
    void 第九() {
        System.out.println("第 9 AfterGroups 有对应组方法的时候运行，运行在所有组方法之后");
    }

    @BeforeMethod
    void 第十() {
        System.out.println("第10 BeforeMethod 在每个有@Test注解的方法之前运行");
    }

    @AfterMethod
    void 第十一() {
        System.out.println("第11 AfterMethod 在每个有@Test注解的方法之后运行");
    }

}

