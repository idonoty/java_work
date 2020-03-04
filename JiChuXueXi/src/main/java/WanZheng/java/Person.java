package WanZheng.java;

//import sun.jvm.hotspot.memory.HeapBlock;

import java.sql.SQLOutput;

public class Person {
    public static void main(String[] args) {
        String hear = "token=11;user=123;";
        String[] header_array = hear.split(";");
        for (String header : header_array) {
            String[] key_array = header.split("=");
            System.out.println(key_array[1]);
            System.out.println(key_array[0]);

        }
    }
}