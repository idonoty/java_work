package JiCheng;

public class DongWuYuan {
    void dog(){
        System.out.println("狗在跑");
    }
}

class DOG extends DongWuYuan{
    void dog(){
        System.out.println("重写跑");
    }
    void dog(int i){
        System.out.println("重载跑"+i);
    }

    public static void main(String[] args) {
        DongWuYuan D = new DOG();
        D.dog();
        ((DOG) D).dog(8);
        DongWuYuan d = new DongWuYuan();
        d.dog();
    }
}


