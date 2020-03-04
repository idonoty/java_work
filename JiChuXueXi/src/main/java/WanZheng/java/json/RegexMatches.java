package WanZheng.java.json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
正则例子
**/
public class RegexMatches {
	
	public static void main(String[] args) {
		  String test ="{\"msg\":\"登录成功\",\"uid\":\"DAD3483647A94DBDB174C4C036CA8A80\",\"code\":\"1\"}";
		
		   String regex = "(.+?):(.+?),\"code\":(.+?)}";// 使用非贪婪模式！
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(test);
	        while (matcher.find()) {
	        	System.out.println(matcher.group());
	        	System.out.println("----------");
				System.out.println(matcher.group(0));
	        	  System.out.println(matcher.group(1));
	        	  System.out.println(matcher.group(2));

	        	  String str = "huang";
				str = str.replace(str,"yi");
				System.out.println(str);

			}

		
		
	}

}
