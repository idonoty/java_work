package FangFaCaoZuo;

import java.util.Scanner;

public class YiChang {
    static int a;
    static int b;
    static int c;

    static void chuFa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        try {                                                   //定义一个异常捕获语句，若无异常则进行下列操作
            a = sc.nextInt();
            b = 100 / a;  //((double)100)/a;  使用double可以除完带小数，但是上方定义b也需要用double
            c = 100 % a;
            System.out.println("100整除" + a + "等于：" + b + ",余数为：" + c);
        } catch (ArithmeticException e) {                         //若抛出除数不能为0时的异常，捕获后进行下列操作
            System.out.println("除数不能为0");
            chuFa();
        } catch (java.util.InputMismatchException e) {            //若抛出键盘取值不符合数据类型限制的异常，捕获后进行下列操作
            System.out.println("不能输入非数字");
            chuFa();
        }finally {                                                //无论怎样都会运行finally下的代码
            System.out.println("嗷嗷");
        }
        //finally { System.out.println("使用finally时，是否出现异常都会执行这行代码"); }
    }

    public static void main(String[] args) {
        chuFa();
    }
}

class throwsYC{
    static void THROW ()throws ArithmeticException,ClassCastException {    //throws异常写在方法名后面，自己运行时没发现异常，但让其他调用者看到可能抛出的异常，多个异常用逗号隔开
        int a = 2;
        int b = 100/2;
        System.out.println(b);
        throw new IllegalArgumentException();   //throw异常写在方法内，运行到这一行时，主动抛出一个异常
    }

    public static void main(String[] args) {
        THROW();
    }
}