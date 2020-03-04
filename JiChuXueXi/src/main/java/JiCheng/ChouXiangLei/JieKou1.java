package JiCheng.ChouXiangLei;
/*
当一个类中的所有方法都是抽象方法时，这个类可以写成接口形式，但是编译完还是class文件
好处：1.接口可以进行多实现，弥补java不能进行多继承的弊端
     2.接口可以在子类继承一个父类的同时，实现多个接口，使子类的属性更丰富
     3.接口中常见的成员有全局常量和抽象方法，它们都是默认公开的，未写关键字也会自动认为有 pubilc，static，final，abstract。
     4.虽然接口会自动补全关键字，但是还是要写上修饰符，便于阅读，而且在实现时避免权限混乱
 */
interface JieKou1 {
    int NUM1=4; //自动补全了final，其实不是变量，是常量，接口中没有变量存在
    public static final String str ="哈哈"; //这种写法其实和上面的是一样的，但是便于阅读
    public abstract void show1();  //和下面的写法是一样的，但是便于阅读
    void show2();}

interface JieKou2 {
    public abstract void show3();}

class FuLei{
    void fuLei1(){
        System.out.println("这是一个父类的方法");
    }}

class ShiXian1 extends FuLei implements JieKou1,JieKou2{
    public void show1(){
        System.out.println("实现第一个接口的方法1");
    }
    public void show2(){             //若接口处未写public方法，其实接口已自动补全，但是这里会误以为不是public，不写就会报错，权限混淆
        System.out.println("实现第一个接口的方法2");
    }
    public void show3(){
        System.out.println("实现第二个接口的方法3");
    }}

class DiaoYong{
    public static void main(String[] args) {
        ShiXian1 shiXian1 =new ShiXian1();
        shiXian1.show1();  //实现1，2，3方法，1，2和3分别是不同的接口
        shiXian1.show2();
        shiXian1.show3();
        shiXian1.fuLei1(); //继承父类中的方法
    }
}

//接口的实际应用
interface USB{  //定义规则
    public abstract void open();
    public abstract void close();
}

class PC {
    //这里做一个接口类型的引用，这个引用指向（接收）的其实都是接口的子类对象。即实现接口的类
    public static void shiYongUSB(USB usb) {  //使用规则
        usb.open();
        usb.close(); }

    public static void main(String[] args) {
        shiYongUSB(new Upan());  //功能拓展
        }}

//使用接口，降低U盘和PC之间的耦合性（紧密联系性，降低则提高独立性）
class Upan implements USB{  //实现规则
    public void open(){
        System.out.println("使用USB");
    }
    public void close(){
        System.out.println("关闭USB");
    }
}
