package HttpClient.JiChu;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Get_cookie {
    public CookieStore Get_cookies() {
        CookieStore cookie = null;
        try {
            HttpGet get = new HttpGet("https://www.baidu.com/");
            cookie = new BasicCookieStore();                         //定义cookie
            CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();  //定义请求并添加写入cookie
            httpclient.execute(get);           //获取cookies信息
//            result = EntityUtils.toString(response.getEntity(), "utf-8");
//            String cookie = null;
//            List<Cookie> cookies = store.getCookies();
//            for (Cookie Cookie : cookies) {
//                cookie = (Cookie.getName() + ":" + Cookie.getValue());         //这一段是将完整的cookie整合起来
//                System.out.println(cookie);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookie;
    }

    public void getwithCookies() {
        try {
            CookieStore cookie = new Get_cookie().Get_cookies();    //将上面获取到的cookie赋值
            HttpPost post = new HttpPost("http://api.codai.vip/user/bindEmail.json?email=QVNTD1U3T@139.com");
            CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();         //创建HTTP连接，加入cookie
            //设置cookies信息
            HttpResponse response = httpclient.execute(post);    //发送请求，此时已经携带了cookie
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            if (statusCode == 200) {                //当请求返回code为200（即请求成功），运行下列输出返回的参数
                String result2 = EntityUtils.toString(response.getEntity());
                System.out.println(result2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Get_cookie().getwithCookies();
    }
}

