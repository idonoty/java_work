package WanZheng.java.day01.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.testng.annotations.Test;

public class FangFa {
    public int fangFa() {  //当不用void时，必须return，这样直接调用方法就直接获取该return的值。
        int a = 8;
        return a;
    }
}
class aa{
    public static void main(String[] args) {
        FangFa I = new FangFa();
        System.out.println(I.fangFa());
    }
}
class bb{
    public bb(){   //方法名和类名相同是构造方法
        System.out.println("构造方法");
    }
    public bb(int a){ //方法名和类名相同，而且需要传参
        System.out.println("重载方法："+a);
    }

    public static void main(String[] args) {
        bb BB=new bb(1);//当实例化时，在类的括号里面写了参数则默认调用传参的方法
    }
}
