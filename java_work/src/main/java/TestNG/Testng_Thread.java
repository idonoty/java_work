package TestNG;

import DuoXianCheng.POST_PDD;
import org.testng.annotations.Test;

public class Testng_Thread {
//threadPoolSize是线程数，invocationCount是总共执行次数
        @Test(threadPoolSize=10,invocationCount=500)
        public void testThread(){
            POST_PDD P =new POST_PDD();
            P.city();
        }


}
