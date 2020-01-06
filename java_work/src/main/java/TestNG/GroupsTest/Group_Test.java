package TestNG.GroupsTest;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/*
分组测试时，组前组后方法
 */
public class Group_Test {
    @Test(groups = "sever")
    public void groupsTest_1(){
        System.out.println("这是sever端的测试方法1");
    }

    @Test(groups = "client")
    public void groupsTest_3(){
        System.out.println("这是client端的测试方法3");
    }
    @Test(groups = "admin")
    public void groupsTest_4(){
        System.out.println("这是admin端的测试方法1");
    }

    @BeforeGroups("sever")
    public void brforeGroupsOnSever(){
        System.out.println("sever端运行前方法");
    }

    @AfterGroups("sever")
    public void afterGroupsOnSever(){
        System.out.println("sever端运行后方法");
    }

    @BeforeGroups("admin")
    public void brforeGroupsOnAdmin(){
        System.out.println("admin端运行前方法");
    }

    @AfterGroups("admin")
    public void afterGroupsOnAdmin(){
        System.out.println("admin端运行后方法");
    }
}
