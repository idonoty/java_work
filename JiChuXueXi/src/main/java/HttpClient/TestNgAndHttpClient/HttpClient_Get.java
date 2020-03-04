package HttpClient.TestNgAndHttpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HttpClient_Get {
    private BasicCookieStore store;

    @Test
    public void test_baidu() throws IOException {
        String result;
        HttpGet httpGet =new HttpGet("http://www.baidu.com");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response=httpclient.execute(httpGet);
        result=EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
    }

    @Test
    public void test_getcookies() throws IOException {
        String result;
        this.store=new BasicCookieStore();
        HttpGet httpGet =new HttpGet("http://localhost:8088/getcookies");
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpResponse response=httpclient.execute(httpGet);
        result=EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
        List<Cookie> cookielist = store.getCookies();
        for(Cookie cookie: cookielist){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name =" + name+"; Cookie value=" + value);
            System.out.println();
        }
    }

    @Test(dependsOnMethods = "test_getcookies")
    public void test_setcookies() throws IOException {
        String result;
        HttpGet httpGet =new HttpGet("http://localhost:8088/getwithcookies");
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(this.store).build();
        CloseableHttpResponse response=httpclient.execute(httpGet);
        result=EntityUtils.toString(response.getEntity(),"UTF-8");
        int code =response.getStatusLine().getStatusCode();
        System.out.println(result+code);
    }
}
