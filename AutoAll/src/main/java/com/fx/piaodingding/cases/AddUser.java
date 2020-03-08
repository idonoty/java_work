package com.fx.piaodingding.cases;

import org.testng.annotations.Test;

@Test
public class AddUser {
    public void test1(){
        System.out.println("测试报告是否生成1");
    }
    public void test21(){
        System.out.println("测试报告是否生成2");
    }
    public void test31(){
        System.out.println("测试报告是否生成3");
        throw new ArithmeticException();
    }
    public void test41(){
        System.out.println("测试报告是否生成4");
    }
}
