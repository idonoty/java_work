package HttpClient.xuexi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
    // 代理开关
    static CookieStore cookie = new BasicCookieStore();   //定义cookie
    public static boolean openProy = true;  //为true时，抓包工具才能抓到接口
    static RequestConfig requestConfig;

    static {
        // 代理设置
        HttpHost proxy = new HttpHost("127.0.0.1", 8080); //填写本地的IP和端口号，如果连别人的抓包工具就写别人的
        // ConnectTimeout： 链接建立的超时时间；
        // SocketTimeout：响应超时时间，超过此时间不再读取响应；
        // ConnectionRequestTimeout： http clilent中从connetcion pool中获得一个connection的超时时间；
        requestConfig = RequestConfig.custom().setProxy(proxy).setConnectTimeout(10000).setSocketTimeout(10000)
                .setConnectionRequestTimeout(3000).build();
    }

    /**
     * get 请求
     *
     * @param url
     * @param headers
     * @return
     */
    public static String doGet(String url, String interFace, String params, String headers) {  //写一个get方法请求接口，传参为TestCase文件中定义的参数名
        // 创建http 默认请求池，（新发现的方法，既可以将本接口cookie写入到变量中，也可以将上接口的cookie用于本次请求，完美）
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();
        HttpGet get = new HttpGet(url + interFace + params);                            //以get方式请求，传参为apitest中从excel获取的数据
        HttpEntity httpEntity = null;                                              //定义请求返回值
        String result = null;
        try {
            if (headers != null) {                                                 //如果头部信息不为空
                String[] header_array = headers.split(";");                  //以 ; 为分隔符区分多个headers参数，建立一个列表
                for (String header : header_array) {
                    String[] key_array = header.split("=");                  //列表中用 = 作为分隔符区分
                    get.addHeader(key_array[0], key_array[1]);                     //使用索引取header的key和value添加至get方法（等号前面的索引为0，等号后面的为1）
                }
            }
            if (openProy) {
                get.setConfig(requestConfig);                                      //这一步是和上面代理为true对应
            }
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(get); //将HTTP执行的get请求赋值给一个封装的类
            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {    //该类下的方法获取到接口返回的code是否为200
                httpEntity = closeableHttpResponse.getEntity();                    //为200的话获取到接口返回参数
                result = EntityUtils.toString(httpEntity, "utf-8");   //将参数以String格式，编码格式为UTF-8赋值给变量
            } else {
                result = "接口返回错误";                                            //若code不是200就输出错误
            }

        } catch (IOException e) {                                                   //解决异常
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;                                                          //return返回值

    }


    /**
     * post 请求
     *
     * @param url
     * @param params
     * @param headers
     * @return
     */


    public static String doPost(String url, String interFace, String params, String headers) {
        // 创建http 默认请求池
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();
        HttpPost post = new HttpPost(url + interFace);
        HttpEntity httpEntity = null;
        String result = null;
        try {
            if (params != null) {
                // 参数处理，核心是 UrlEncodedFormEntity 需要List<NameValuePair>
                List<NameValuePair> list = new ArrayList<NameValuePair>();
                String[] params_array = params.split("&");
                for (String param : params_array) {
                    String[] param_array = param.split("=");
                    list.add(new BasicNameValuePair(param_array[0], param_array[1]));
                }
                if (list.size() > 0) {
                    post.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
                }
            }
            // 处理header
            if (headers != null) {
                String[] header_array = headers.split(";");
                for (String header : header_array) {
                    String[] key_array = header.split("=");
                    post.addHeader(key_array[0], key_array[1]);
                }
            }
            if (openProy) {
                post.setConfig(requestConfig);
            }
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(post);
            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
                httpEntity = closeableHttpResponse.getEntity();
                result = EntityUtils.toString(httpEntity, "utf-8");
            } else {
                result = "接口返回错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
//这下面原来是单独写入cookie的方法，后面找到了新方法不用多此一举了
//    public static String doGet_Cookie(String url, String interFace, String params, String headers) {    //包含cookie的get方法
//        // 创建http 默认请求池
//        CookieStore cookie = Get_cookies.getCookie();
//        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();    //创建HTTP连接,并且加入cookie;
//        HttpGet get = new HttpGet(url + interFace + params);                                        //以get方式请求
//        HttpEntity httpEntity = null;                                                                   //定义请求返回值
//        String result = null;
//        try {
//            if (headers != null) {
//                String[] header_array = headers.split(";");
//                for (String header : header_array) {
//                    String[] key_array = header.split("=");
//                    get.addHeader(key_array[0], key_array[1]);
//                }
//            }
//            if (openProy) {
//                get.setConfig(requestConfig);
//            }
//            CloseableHttpResponse closeableHttpResponse = httpclient.execute(get);
//            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
//                httpEntity = closeableHttpResponse.getEntity();
//                result = EntityUtils.toString(httpEntity, "utf-8");
//            } else {
//                result = "接口返回错误";
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                EntityUtils.consume(httpEntity);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;                                                          //return返回值
//    }
//
//    public static String doPost_Cookie(String url, String interFace, String params, String headers) {    //包含cookie的post方法
//        // 创建http 默认请求池
//
//        CookieStore cookie = Get_cookies.getCookie();
//        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookie).build();         //创建HTTP连接，加入cookie
//        HttpPost post = new HttpPost(url + interFace);
//        HttpEntity httpEntity = null;
//        String result = null;
//        try {
//            if (params != null) {
//                // 参数处理，核心是 UrlEncodedFormEntity 需要List<NameValuePair>
//                List<NameValuePair> list = new ArrayList<NameValuePair>();
//                String[] params_array = params.split("&");                       //和header一样，不过是用 & 分割参数，= 分割获取索引
//                for (String param : params_array) {
//                    String[] param_array = param.split("=");
//                    list.add(new BasicNameValuePair(param_array[0], param_array[1]));
//                }
//                if (list.size() > 0) {
//                    post.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
//                }
//            }
//            // 处理header
//            if (headers != null) {
//                String[] header_array = headers.split(";");                  //以 ; 为分隔符区分多个headers参数，建立一个列表
//                for (String header : header_array) {
//                    String[] key_array = header.split("=");                  //列表中用 = 作为分隔符区分
//                    post.addHeader(key_array[0], key_array[1]);
//                }
//            }
//            if (openProy) {
//                post.setConfig(requestConfig);
//            }
//            CloseableHttpResponse closeableHttpResponse = httpclient.execute(post);
//            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
//                httpEntity = closeableHttpResponse.getEntity();
//                result = EntityUtils.toString(httpEntity, "utf-8");
//            } else {
//                result = "接口返回错误";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                EntityUtils.consume(httpEntity);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }
}
