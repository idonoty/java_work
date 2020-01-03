package HttpClient.xuexi;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuYinHao {
    public static void main(String[] args) {
        String s = "\"[{\"email\":\"8851204@qq.com\"}]\"";
        System.out.println(s.charAt(0)+"  "+s.charAt(s.length()-1));
        char a = s.charAt(0);
        String b=String.valueOf(s.charAt(0));
        String c=String.valueOf(s.charAt(s.length()-1));
        if (b.equals("\"") && c.equals("\"")){
        System.out.println(s.substring(1,s.length()-1));
        }else {
            System.out.println(b+c+"111");
        }
    }
    }

