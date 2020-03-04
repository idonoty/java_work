package WanZheng.java.day01.test;

import java.util.ArrayList;

public class Testshuzu01 {
    public static void main(String[] args) {
        int [] arr ={1,2,5,7,10,3};
        double [] arrl = {1,10,8,7};
        Object[] arrll ={1,"啊啊",1.9};
        //Object中可以放入任何类型的参数，是父类
        System.out.println(arr.length);
        //length:上述输出arr数组的长度，6个参数
        ArrayList list1 = new ArrayList();
        list1.add(1);
        System.out.println(list1);
        //数组用的大括号，列表用中括号
    }


}
