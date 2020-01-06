package TestNG;

import org.testng.annotations.Test;

public class Exception_Test {
    //失败的异常测试，声明的预期异常没有在方法中抛出
    @Test(expectedExceptions = ArithmeticException.class)
    public void FalseException(){
        System.out.println("这个方法运行失败，因为没有抛出声明的异常");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void FalseException2(){
        System.out.println("这个方法运行失败，因为抛出的异常和声明的不一致");
        throw new RuntimeException();
    }


    @Test(expectedExceptions = ArithmeticException.class)
    public void SuccessException(){
        System.out.println("这是一个成功的预期异常测试");
        System.out.println(100/0);
        System.out.println("预期异常后，异常代码后的代码无法运行");
    }


    @Test(expectedExceptions = RuntimeException.class)
    public void SuccessException2(){
        System.out.println("这是一个成功的预期异常测试");
        throw new RuntimeException();
    }
}
