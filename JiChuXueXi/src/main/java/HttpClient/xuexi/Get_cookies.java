package HttpClient.xuexi;

import com.github.crab2died.ExcelUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.client.CookieStore;


import java.io.File;
import java.util.List;

public class Get_cookies {
    public static CookieStore getCookie() {
        CookieStore cookie = null;
        String path = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator +"自动化excel"+ File.separator +"jiekou.xls";
        try {
            List<TestCase> list = ExcelUtils.getInstance().readExcel2Objects(path, TestCase.class);
            for (TestCase testCase : list) {
                if ("登陆".equals(testCase.getCaseName())) {  //只有登陆接口获取cookie
                    HttpGet get = new HttpGet(testCase.getUrl() + testCase.getInterFace() + testCase.getParams());   //添加接口url
                    cookie= new BasicCookieStore();                         //定义cookie
                    CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();  //定义请求并添加写入cookie
                    httpclient.execute(get);                   //发送请求
                    //System.out.println(cookie);
                } else {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookie;
    }

    public static void main(String[] args) {
         Get_cookies.getCookie();
    }
}
