package TestNG.GroupsTest;

import org.testng.annotations.Test;

@Test(groups = "class1")
public class GroupsClass_Test1 {
    public void def1(){
        System.out.println("类分组 1 中的方法1");
    }

    public void def2(){
        System.out.println("类分组 1 中的方法2");
    }
}
