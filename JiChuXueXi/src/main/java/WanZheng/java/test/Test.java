package WanZheng.java.test;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        System.out.println(System.getProperty("use.dir"));
        System.out.println(System.getProperty("use.dir") + File.separator +"src" );
        String path2 = System.getProperty("user.dir");
        System.out.println(path2);


    }
}
