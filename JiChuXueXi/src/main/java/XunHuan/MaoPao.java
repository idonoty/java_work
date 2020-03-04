package XunHuan;

public class MaoPao {
    static int[] ShuZu = {6,5,4,3,2,0};     //数组内有6个参数

    public static void main(String[] args) {
        for (int i = 0; i < ShuZu.length; i++) { //循环数组5次，每次从第一个到最后一个全部走一遍
            for (int j = 0; j < ShuZu.length - 1; j++) { //相邻的两个数比大小，交换次数为5（若最后一个最小，则需要交换5次位置）
                if (ShuZu[j] > ShuZu[j + 1]) {   //如果前面一个值大于后面的值
                    int temp = ShuZu[j + 1];     //则将后面的较小的值赋予一个参数
                    ShuZu[j + 1] = ShuZu[j];     //将后面的值等于前面较大的值
                    ShuZu[j] = temp;             //将前面的值等于赋予参数（较小的值），完成前后交换
                }
            }
        }
        for (int BL : ShuZu) {                   //用foreach输出排列好的参数
            System.out.println(BL);
        }

    }
}

