package JiChuCaoZuo;

public class  If_else {
    public static void main(String[] args) {
        int a = 2;
        if (a > 3) {
            System.out.println("数字大于3");
        } else if (a == 3) {
            System.out.println("数字等于3");
        } else {
            System.out.println("数字小于3");
            AA();
        }
    }
    void wukuohaoif(){
        if(1+2>3)
            System.out.println("大于");
        else
            System.out.println("小于");
    }
    static void AA() {
        int a = 10;
        int b = 20;
        if (a >= 10) {
            if (b > 20) {
                System.out.println("真的");
            } else {
                System.out.println("假的");
            }
        } else {
            System.out.println("傻逼");
        }
    }
}

