package HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class HttpTest {
    public static void main(String[] args) {
        Map data = new HashMap();
        data.put("username","yyc1");
        data.put("password","yyc111");
        data.put("device","30");
        String ru=The_HttpClient.doPost("http://api.codai.vip/login.json?",data);
        System.out.println(ru);
    }
}
