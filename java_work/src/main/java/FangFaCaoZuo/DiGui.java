package FangFaCaoZuo;

import java.util.Scanner;

public class DiGui {
    static int a;
    static int b;

    static void chuFa() {
        Scanner sc = new Scanner(System.in);  //从键盘取值
        System.out.println("请输入一个数字");
        while (!sc.hasNextInt()) {            //判断取值是否为数字，不是则一直循环
            sc.next();                        //随意取值
            System.out.println("请输入数字");
        }
        a = sc.nextInt();                     //当取值为数字时赋值给a
        if (a == 0) {
            System.out.println("请输入非0数字");
            chuFa();               //当不满足条件时，重新执行一遍方法
        } else {
            b = 100 / a;
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        chuFa();
    }
}

