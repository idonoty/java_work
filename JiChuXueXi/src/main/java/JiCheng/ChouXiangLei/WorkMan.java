package JiCheng.ChouXiangLei;
/*
一个公司有员工和经理，员工有姓名，工号，薪水和工作内容，
经理除此之外还有奖金建立一个模型使公司体系简单明了
 */

public abstract class WorkMan{
    private String name;
    private int id;
    private int salary;
    WorkMan(String name,int id,int salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    //工作内容用抽象方法表示
    abstract void jobContent();
}

class Staff extends WorkMan{
    //首先调用父类中的构造方法获取姓名，工号和薪水
    Staff(String name,int id,int salary){
        super(name,id,salary);
        System.out.println("员工姓名:"+name+"，员工工号:"+id+"，员工薪水:"+salary);
    }
    public void jobContent(){
        System.out.println("脏活累活全包办");
    }
}
class Manager extends WorkMan{
    private int bonus;
    Manager(String name,int id ,int salary,int bonus){
        super(name,id,salary);
        this.bonus=bonus;
        System.out.println("经理姓名:"+name+"，经理工号:"+id+"，经理薪水:"+salary+"，经理奖金:"+bonus);
    }
    void jobContent(){
        System.out.println("我是管理层");
    }
}

class Company{
    public static void main(String[] args) {
        Staff staff =new Staff("小李",10,1000);
        staff.jobContent();
        Manager manager=new Manager("王经理",101,2000,1000);
        manager.jobContent();
    }
}

//public abstract class WorkMan
//{
//    abstract void name();
//    abstract void jobNumber();
//    abstract void salary();
//    abstract void jobContent();
//}
//
//class Employee extends WorkMan{
//    void name(){
//        System.out.println("a");
//    }
//    void jobNumber(){
//        System.out.println("b");
//    }
//    void salary(){
//        System.out.println("c");
//    }
//    void jobContent(){
//        System.out.println("d");
//    }
//
//    public static void main(String[] args) {
//        Employee employee =new Employee();
//        employee.jobContent();
//    }
//}
