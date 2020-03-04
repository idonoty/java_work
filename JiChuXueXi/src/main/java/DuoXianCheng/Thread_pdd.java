package DuoXianCheng;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Thread_pdd {
    static int i;
    static List<EXCASE> A= new ArrayList();

    public static void main(String[] args) {
        {
            for ( i = 0; i <500; i++) {
                System.out.println("开启线程" + i);
                new Thread("线程" + i) {
                    public void run() {
                        POST_PDD.city();
                    }
                }.start();
            }
        }
    }
}
