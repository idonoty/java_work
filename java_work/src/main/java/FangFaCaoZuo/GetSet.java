package FangFaCaoZuo;

public class GetSet {
    static int []A={1,3,4};
    private static int a;
    private static String name="tom";
    //使用getset方法时一般都要带上private，不能随意修改参数的值

    public int getA() {
        return a;
    }

    public void setA(int a) { this.a = a+1;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GetSet AA = new GetSet();
        AA.setA(23);    //先用set方法给定参数，在使用get得到该参数，不能随便查看中间运行的过程。
        System.out.println(AA.getA());
        AA.setName("MM");
        System.out.println(AA.getName());
        int B =AA.getA() + 1;
        System.out.println(B);
    }
}
