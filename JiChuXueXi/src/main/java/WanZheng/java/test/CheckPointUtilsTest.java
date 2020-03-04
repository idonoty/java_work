package WanZheng.java.test;


import WanZheng.java.utils.httpclient.check.CheckPointUtils;

public class CheckPointUtilsTest {
	   public static void main(String[] args) {
		    //jsonobject 测试
			System.out.println("-----json校验");
		    String testjson ="{\"uid\":\"test\"}";
			System.out.println(CheckPointUtils.check(testjson,"uid=test").getMsg());
			
			System.out.println("-----不存在值判断");
			System.out.println(CheckPointUtils.check(testjson,"test=12").getMsg());
			
			//json数组测试
			System.out.println("-----json数组测试");
			String testjson2="{\"code\":\"1\",\"data\":[{\"name\":\"testfan0\",\"pwd\":\"pwd0\"},{\"name\":\"testfan1\",\"pwd\":\"pwd1\"},{\"name\":\"testfan2\",\"pwd\":\"pwd2\"}]}";
			System.out.println(CheckPointUtils.check(testjson2,"..name[0]=testfan0").getMsg());
			//函数测试 
			System.out.println("-----函数测试 ");
		    System.out.println(CheckPointUtils.check(testjson2,"data.size()>5").getMsg());
			//多值组合测试
		    System.out.println("-----多值组合测试 ");
		    String testjson3 ="{\"msg\":\"登录成功\",\"uid\":\"DAD3483647A94DBDB174C4C036CA8A80\",\"code\":\"1\",\"code2\":\"2\",\"code3\":\"3\"}";
		   // CheckPointUtils.openLog=true;
		    System.out.println(CheckPointUtils.check(testjson3,"code=1&&code2>=4&&code3>=4").getMsg());
	   }

}
