package WanZheng.java.day01.test;

public class JiCheng {
    void FLff(){
        System.out.println("父类方法");
    }
}
class jicheng extends JiCheng{
    void ZLff(){
        System.out.println("子类方法");
    }

    public static void main(String[] args) {
        JiCheng aa = new jicheng();
        aa.FLff();
        ((jicheng) aa).ZLff();
    }
}