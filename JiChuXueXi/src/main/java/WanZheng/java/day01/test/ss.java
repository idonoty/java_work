package WanZheng.java.day01.test;

public class ss {


    public static void main(String[] args) {
        int [] AA={1,5,2,65,7};
        for (int i = 0; i <AA.length ; i++) {
            for (int j = 0; j <AA.length-1 ; j++) {
                if (AA[j]>AA[j+1]);
                    int bb=AA[j+1];
                    AA[j+1]=AA[j];
                    AA[j]=bb;
            }
        }
        for (int BB:AA){
            System.out.println(BB);

        }
    }
//}
}
