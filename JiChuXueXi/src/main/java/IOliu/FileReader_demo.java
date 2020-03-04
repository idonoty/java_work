package IOliu;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_demo {
    //文件找不到会抛出异常，所以要声明
    public static void main(String[] args) throws IOException {
        FileReader fd = new FileReader("C:\\Users\\Lenovo\\Desktop\\FileWriter_demo.txt");
        //这样是一次只读一个字符，并且返回它的二进制,读到最后，无字符了会返回-1
        int ch=fd.read();
        System.out.println(ch);
        //如果要返回它的原文字，则：
        System.out.println((char)ch);
        for (int i = fd.read(); i !=-1 ; i=fd.read()) {
            System.out.println((char)i);
        }
        fd.close();
        //读成数组，read方法只支持char数据类型
        FileReader fd2 = new FileReader("C:\\Users\\Lenovo\\Desktop\\FileWriter_demo.txt");
        char[] buf =new char[10];
        int num =fd2.read(buf);
        System.out.println(new String(buf));
        fd2.close();
    }
}
