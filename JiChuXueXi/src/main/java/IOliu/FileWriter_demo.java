package IOliu;

import java.io.FileWriter;
import java.io.IOException;

/*
创建一个可以往文件中写入字符数据的字符输出流对象
往文件中写入文字数据，则创建对象时，必须明确文件路径（存储目的地）
 */
public class FileWriter_demo {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        //必须明确它可能抛出的异常（存储路径不存在）
        //若路径下无文件，则会自动创建，若文件存在则会被覆盖
        FileWriter fileWriter = new FileWriter("C:\\Users\\Lenovo\\Desktop\\FileWriter_demo.txt");
        //写入字符，这时候不会保存至硬盘，而是保存在缓存流中（内存）
        fileWriter.write("ABCDE");
        //如果要换行，Windows和linux的换行符是不同的，分别是/r和/n，则可定义一个通用换行符
        fileWriter.write("aaaa" + LINE_SEPARATOR + "bbbb");
        //需要进行刷新操作，即可保存
        fileWriter.flush();
        fileWriter.write("飒飒");
        //写入完毕后，使用close关闭流，否则会占用资源，关闭时会先保存（即进行一次flush操作）
        //关闭后无法再进行写入和刷新操作，会抛出IOException: Stream closed 异常
        fileWriter.close();

        //如果要在原文件上续写，而不覆盖它，则在new对象的时候，文件路径后加入",true" 即可
        FileWriter fileWriter2 = new FileWriter("C:\\Users\\Lenovo\\Desktop\\FileWriter_demo.txt", true);
        fileWriter2.write("奥术大师法发顺丰阿萨德");
        fileWriter2.close();
    }
}

/*
简单处理io流异常
 */
class IOException_demo {
    public static void main(String[] args) {
        //一般处理IO流时，将对象变量在try外面定义，里面实例化
        FileWriter fw = null;
        try {
            //找不到路径则会抛出异常
            fw = new FileWriter("D:\\A");
            fw.write("asda");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //若上面找不到路径，则fw实例化失败，对象为空(null)，则关闭时会产生空指针异常(NullPointerException)
            //需要避免空指针异常
            if (fw != null) {
                try {

                    fw.write("abc");
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            }
        }

    }
}