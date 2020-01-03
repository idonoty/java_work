package JiCheng.DuoTai;

abstract class Animal {  //定义父类
    abstract void eat();
    abstract void run();}

class Dog extends Animal{
    void eat(){
        System.out.println("啃骨头"); }
    void run(){
        System.out.println("遛弯"); }
    void lookHome(){
        System.out.println("看家"); }}

class Cat extends Animal{
    void eat(){
        System.out.println("吃鱼"); }
    void run(){
        System.out.println("爬树"); }
    void catchMouse(){
        System.out.println("抓老鼠"); }}

class DuoTai{
    public static void main(String[] args) {
        method(new Cat());
        method(new Dog()); }
    static void method(Animal animal){  //使用多态，则调用时 Animal animal = new Cat();
        animal.eat();
        animal.run(); }
//    static void method(Cat cat){   //不用多态，则每有一个新子类继承父类，都需要写一个方法 Cat cat = new Cat();
//        cat.eat();
//        cat.run();
//    }
//    static void method(Dog dog){
//        dog.eat();
//        dog.run();
//    }
}
