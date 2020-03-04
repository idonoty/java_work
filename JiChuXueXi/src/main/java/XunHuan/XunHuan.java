package XunHuan;

public class
XunHuan {
    static void WhileXH() {
        int a = 10;
        while (a < 20) {
            a = ++a;
            System.out.println(a);
        }
        /*
        获取1到10的和,1+2+3+4+..+10,累加算法
         */
        int b = 1, c = 0;
        while (b <= 10) {
            c = c + b;
            b++;
        }
        System.out.println("求和结果" + c);
        /*
        获取1-100中，6的倍数出现的次数,计数器算法
         */
        int d = 0, e = 1;
        while (e <= 100) {
            if (e % 6 == 0) {
                d++;
            }
            e++;
        }
        System.out.println("6的倍数出现的次数为" + d);
    }

    static void ForXH() {
        for (int b = 20; b < 30; ++b) {
            System.out.println(b);
        }
        //for循环多种写法都可以
        for (int a = 10, b = 20; a > 1 && b < 30; ++b,--a) {
            System.out.println(b);
        }
        int i = 1;
        for (System.out.println("a"); i < 3; System.out.println("b")) {
            System.out.println("c");
            i++;
        }
        int sum=0;
        for (int j = 1; j <=10 ; j++) {
            sum=sum+j;
        }
        System.out.println("for循环累加："+sum);
    }

    static void ForRXH() {
        int[] A = {1, 2, 3, 4, 5};
        for (int a : A) {
            System.out.println(a);
            if (a == 2) {
                System.out.println("现在是：" + a);
            } else {
                System.out.println("其实是" + a);
            }
            switch (a) {
                case 1:
                    System.out.println("第" + a + "次输出");
                    break;
                case 2:
                    System.out.println("第" + a + "次输出");
                    break;
                default:
                    System.out.println("第" + a + "次输出");
            }
        }
    }

    public static void main(String[] args) {
        WhileXH();
        ForXH();
        ForRXH();
    }
}
