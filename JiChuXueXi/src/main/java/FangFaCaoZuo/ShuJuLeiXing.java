package FangFaCaoZuo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.dc.pr.PRError;

import java.util.ArrayList;

/**
 * 这是对数据类型和运算符基础的一个运算文件
 */
public class ShuJuLeiXing {
    public static void A(){
        int a=2;
        byte b=3;
        a=a+b;
        //b=a+b;不行，因为四个八位无法直接塞入单个八位
        b=(byte)(a+b); //可以运行，但是会丢失精度，在相加后的数值过大时，会导致运算结果错误（4个八位的前三个被扣除）
        System.out.println(a);
        System.out.println(b);
        int[] arr = {1, 2, 5, 7, 10, 3};
        double[] arrl = {1, 10, 8, 7};
        Object[] arrll = {1, "啊啊", 1.9};                       //Object中可以放入任何类型的参数，是父类
        System.out.println(arrll[1]);
        System.out.println(arr.length);                         //length:上述输出arr数组的长度，6个参数
        ArrayList list1 = new ArrayList();
        list1.add(1);
        System.out.println(list1);                             //数组用的大括号，列表用中括号
    }
    public static void B(){
        byte b=3; //byte在赋值时，会检测int数值是否小于128，小于才能赋值，大于127赋值会报错
        byte b1=5;
        byte b2=6;
        b=3+7;    //这可以，因为知道加起来小于128
//        b=1+127;   //不可以，大于等于128
//        b=b1+b2;   //不可以，因为b1,b2是变量，java不知道它们到底是多少，有可能会导致相加大于128，所以不行
        int a=1;
        int a1=Integer.MAX_VALUE;
        int a2=2147483647;
        a= a1+a2; //超出长度后，高位全舍弃，按照二进制再转换成int数值
        System.out.println(a1);
        System.out.println(a);
        System.out.println(Integer.toBinaryString(122)); //查看二进制
    }

    public static void C(){
        int c=4109;
        System.out.println(c%1000);
        System.out.println(5%-2); //如果有负数，得到的结果正负只看被模数（%前面的数，这里是5）
        c=c/1000*1000;
        System.out.println(c);
        int a=6,b=7;
        System.out.println(""+a+b); //如果要同时打印两个数字，而不是相加，直接加字符串即可
        int A=2,B;
        B=A++; //A++时，A自身的值需要先参与其他运算，再进行++操作
        System.out.println("A="+A+",B="+B);  //A=3,B=2
        B=++A; //++A时，A先进行++操作，再参与其他运算
        System.out.println("A="+A+",B="+B);  //A=4,B=4
        int X =1;
        X=X++;
        System.out.println(X); //X=1
        X =1;
        X=++X;
        System.out.println(X); //X=2

        short q=3; //检查后，确认长度符合，进行自动转换再进行赋值
        // +=，-=,*=,/=,%= 都是先运算再赋值
        q+=5;     //先进行3+5的运算，然后检查运算结果符合，然后进行自动转换，再赋值
        //q=q+5;    //无法判断运算时q的长度，可能导致相加结果超出，无法运算
        q=(short)(q+5); //+=就是自动转换了，不然就得手动强转
    }
    public static void D(){
        /*计算1-2+3-4..97-98+99的值
        第一个为正数，第二个为负数，直到99为止
         */
        int sum = 0;
        int temp=1;
        for (int i = 1; i <=99; i++) {
            sum+=i*temp;
            temp=-temp;
        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        A();
        System.out.println("________");
        B();
        System.out.println("________");
        C();
        System.out.println("________");
        D();
    }
}
