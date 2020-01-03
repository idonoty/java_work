package TestNG;


import org.testng.annotations.*;

public class TestNG_HttpClient {

    @Test(priority = 1,groups = "pdd")
    public void getAllPassenger(){
        InterFace_PDD.getAllPassenger();
    }
    @Test(priority = 2,groups = "pdd")
    void getPassengerById(){
        InterFace_PDD.getPassengerById();
    }
    @Test(priority = 3,groups = "pdd")
    void updatePassenger(){
        InterFace_PDD.updatePassenger();
    }
    @BeforeGroups(groups = "pdd")
    void startInterface(){
        System.out.println("开始执行接口");
    }
    @AfterGroups(groups = "pdd")
    void endInterface(){
        getAllPassenger();
        System.out.println("执行接口结束");
    }
    @BeforeClass
    void startClass(){
        System.out.println("开始执行票盯盯接口类");
    }
}
