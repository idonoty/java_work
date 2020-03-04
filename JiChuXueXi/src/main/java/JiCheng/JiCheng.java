package JiCheng;

public class JiCheng {
    JiCheng() {
        System.out.println("父类的构造方法");
        //当父类有构造方法而子类没有时，在子类中实例化是直接调用父类构造方法
        //若子类也有构造方法则实例化时同时调用父类和子类构造方法（继承后的新构造方法直接调用了父类的构造方法）
    }

    void FLFF() {
        System.out.println("父类方法");
    }
    void TMFF(){
        System.out.println("父类中的同名方法");
    }
}

class jc extends JiCheng {   //使用extends继承父类中的所有方法
    jc(){
        System.out.println("子类的构造方法");
    }

    void ZLFF() {
        System.out.println("子类方法");
    }

    void TMFF() {
        System.out.println("子类中的同名方法");
    }

    void SUPER_THIS() {
        super.TMFF();  //当子类与父类中有同名的方法时，使用super则使用父类方法
        this.TMFF();   //使用this则使用子类方法
    }

    public static void main(String[] args) {
        jc BB = new jc();  //实例化子类时，父类也实例化了，可以直接调用父类和子类的方法
        BB.TMFF();         //当子类和父类方法都有同名方法时，默认调用子类，，若需要默认调用父类，则需要单独实例化父类，或者写一个方法用super和this区分
        BB.FLFF();
        BB.ZLFF();
        BB.SUPER_THIS();
    }
}