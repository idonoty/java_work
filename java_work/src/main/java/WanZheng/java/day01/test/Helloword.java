package WanZheng.java.day01.test;

public class Helloword {
    int o=10;
    static final int t=100;
    public void test(){
        System.out.println("hellword");
        int i=99;
        String li="shuaizhao";
        String w = t+li;
        System.out.println(w);
        System.out.println(i);
    }

    public static class helloword1 {
        public static void main(String[] args) {
            Helloword c=new Helloword();
            c.test();
        }
    }
}

