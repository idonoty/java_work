package WanZheng.java.day01.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class MaoPao {
    static int[] ShuZu = {1, 3, 5, 7, 9, 2};

    public static void main(String[] args) {
        for (int i = 0; i < ShuZu.length ; i++) { //
            for (int j = 0; j < ShuZu.length - 1 ; j++) { //前一个数和后面的数比较大小
                if (ShuZu[j] > ShuZu[j + 1]) {
                    int temp = ShuZu[j + 1];//索引该数组的取值
                    ShuZu[j + 1] = ShuZu[j];//若后面的值比前面的小，则将后面的值赋予前面的值
                    ShuZu[j] = temp;//将大的值放在后面
                }
            }
        }
        for (int BL:ShuZu) {
            System.out.println(BL);
        }

    }
}

