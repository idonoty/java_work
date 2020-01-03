package JiChuCaoZuo;

public  class SwitchCase {
        //switch case 语句用来判断值是否相等并作出对应操作
    static String name = "小明";

    static void one() {
            //方法前加入static，则下面调用就不需要new了
        switch (name) {
            case "小刚":
                System.out.println("小刚");
                break;
            case "小宏":
                System.out.println("小宏");
                break;
            case "小明":
                System.out.println("小明");
                break;
                    //若没有break，则判断正确后还会进行下面的操作
            case "小李":
                System.out.println("小李");
                break;
            default:
                    //default语句是进行操作并结束当前switch
                System.out.println("都不是");
        }
    }

    public static void main(String[] args) {
        one();
        System.out.println("实际是：" + name);
    }

}

