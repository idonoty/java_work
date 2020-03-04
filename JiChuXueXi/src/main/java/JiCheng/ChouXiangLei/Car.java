package JiCheng.ChouXiangLei;
public abstract class Car {
    abstract void start();
    abstract void stop();
    Car(){
        System.out.println("这是一个抽象类");
    }
    void run(){
        this.start();
        this.stop();
    }
}


