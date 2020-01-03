package DuoXianCheng;

import org.testng.annotations.Test;

public class Testng_Thread {

        @Test(threadPoolSize=10,invocationCount=500)
        public void testThread(){
            POST_PDD P =new POST_PDD();
            P.city();

        }


}
