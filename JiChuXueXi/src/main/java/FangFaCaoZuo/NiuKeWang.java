package FangFaCaoZuo;

import jdk.internal.util.xml.impl.Input;

import java.util.*;

/*
链接：https://ac.nowcoder.com/acm/contest/320/C
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
 */
class C{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            try{
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a<1 || b>Math.round(Math.pow(10,9))){
                    return;
                } else if(a==0 && b==0){
                    return;
                }else{
                    System.out.println(a+b);
                }
            }catch (InputMismatchException e){
                return;
            }

        }
    }
}

/*
链接：https://ac.nowcoder.com/acm/contest/320/D
输入数据包括多组。
每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
接下来n个正整数,即需要求和的每个正整数。
每组数据输出求和的结果
 */
class D{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            try {
                int n=sc.nextInt();
                int num=0;
                if (n==0){
                    return;
                }
                //只是说了n=0结束，所以其他条件不用结束
//                else if(n<1 || n>100){
//                    return;
//                }
                else {
                    for(int i=0;i<n;i++){
                        int a = sc.nextInt();
                        num =num+a;
                    }
                    System.out.println(num);
                }
            }catch (InputMismatchException e){
                return;
            }
        }
    }
}

/*
链接：https://ac.nowcoder.com/acm/contest/320/E
输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
接下来t行, 每行一组数据。
每行的第一个整数为整数的个数n(1 <= n <= 100)。
接下来n个正整数, 即需要求和的每个正整数。
输出每组数据求和的结果
 */

class E{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            try{
                int t = sc.nextInt();
                for (int i=0;i<t;i++){
                    int num =0;
                    int n =sc.nextInt();
                    for (int j=0; j<n;j++){
                        int a = sc.nextInt();
                        num =num+a;
                    }
                    System.out.println(num);
                }
            }catch (InputMismatchException e){
                return;
            }
        }
    }
}

/*
链接：https://ac.nowcoder.com/acm/contest/320/G
输入第一行包括一个数据组数t(1 <= t <= 100)
接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
每组数据输出求和的结果
 */

class G{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            try{
                int num = 0;
                for (int i = 0; i < 3; i++) {
                    int n = sc.nextInt();
                    num =num+n;
                }
                System.out.println(num);

            }catch (InputMismatchException e){
                return;
            }
        }
    }
}

