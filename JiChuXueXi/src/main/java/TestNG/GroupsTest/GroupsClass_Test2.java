package TestNG.GroupsTest;

import org.testng.annotations.Test;

@Test(groups = "class2")
public class GroupsClass_Test2 {
    public void def1(){
        System.out.println("类分组 2 中的方法1");
    }

    public void def2(){
        System.out.println("类分组 2 中的方法2");
    }
}
