package WanZheng.java.day01.test;


//public class test {
//    public static void main(String[] args) {
//        int a = 10;
//        while (a<20){
//            System.out.println("value of a :"+a);
//            a++;
//            System.out.println("\n");
//        }
//    }
//}
//
//public class test{
//    public static void main(String[] args) {
//        for (int a =1; a < 10; a=a+1){
//            System.out.println("value of a:"+ a);
//            System.out.println("\n");
//        }
//    }
//}
//
//public class test{
//    public static void main(String[] args) {
//        int[] a={1,2,3};
//        for (int x:a){
//            System.out.println(x);
//            System.out.println(".");
//        }
//        System.out.println("\n");
//        String [] names ={""};
//    }

//
//public class test {
//    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        for (int x : a) {
//            System.out.println(x);
//            if (x == 3) {
//                break;
//            }
//        }
//    }
//}


public class test{
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        for (int x:a){
            if (x==3){
            continue;
            }
            System.out.println(x);
        }
    }
}

