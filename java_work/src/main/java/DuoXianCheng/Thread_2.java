package DuoXianCheng;

import WanZheng.java.utils.httpclient.ApiTest;

public class Thread_2 {
    public static void main(String[] args) {
        for(int i=0; i<20; i++){
            new Thread("" + i){
                public void run(){
                    ApiTest A =new ApiTest();
                    A.testcase(false);
                }
            }.start();
        }
    }
    }