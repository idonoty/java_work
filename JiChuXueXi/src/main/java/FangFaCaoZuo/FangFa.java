package FangFaCaoZuo;

public class FangFa {
    static Object [] M={1,"这是",1.3};   //Object中可以放入所有数据类型，数组和列表都可以
    public int fangFa() {  //当不用void时，必须return，这样直接调用方法就直接获取该return的值。
        int a = 8;
        return a;
    }
    public static void main(String[] args) {
        FangFa DD =new FangFa();
        System.out.println(DD.M[2]);  //输出Object中的第三个值
        System.out.println(DD.fangFa()); //直接输出该方法则是return的值
    }
}

class GouZhaoFangFA {
    public GouZhaoFangFA(){   //方法名和类名相同是构造方法
        System.out.println("构造方法");
    }
    public GouZhaoFangFA(int a){ //方法名和类名相同，而且需要传参
        System.out.println("传参的构造方法："+a);
    }

    public static void main(String[] args) {
        GouZhaoFangFA gouZhaoFangFA=new GouZhaoFangFA();//当实例化时，在类的括号里面写了参数则默认调用传参的方法
        GouZhaoFangFA gouZhaoFangFA2=new GouZhaoFangFA(1);
    }
}

class GouZhao2{
    private String name;
    private int age;
    GouZhao2(){
        this("hha",1); //调用下一个构造函数
        name ="baby";
        age=1;
        System.out.println(1);
    }
    GouZhao2(String name,int age){
        //this();  //调用上一个构造函数，因为上面调用了这个，如果都调用会出现内存溢出，重复执行，所以不允许
        this.name=name; //用this修饰本类的变量，和本作用域的作区分
        this.age=age;
        System.out.println(2);
    }
    public void speak(){
        System.out.println("name:"+name+" age："+age);;
    }

    public static void main(String[] args) {
        GouZhao2 G=new GouZhao2();
        G.speak();
        GouZhao2 G2= new GouZhao2("哈啊",2);
        G2.speak();
    }
}

class YongFa3{
    //除了上面两种用法，还有一种this的用法
    private String name;
    private int age;
    YongFa3(String A,int B){
         name=A;
         age=B;
    }
    boolean bijiao(YongFa3 C){
        //用this代表一个对象，进行和其他对象年龄的比较
        return this.age==C.age;  //这里的this代表调用这个方法的对象，也就是下面的Y1，传参C就代表Y2
    }

    public static void main(String[] args) {
        YongFa3 Y1 = new YongFa3("小明",10);
        YongFa3 Y2 = new YongFa3("小宏",19);
        System.out.println(Y1.bijiao(Y2)); //Y1调用的，上面的this就代表Y1
    }
}
