package HttpClient.xuexi;

import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.crab2died.ExcelUtils;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.testng.annotations.Test;

/**
 * 接口测试主类
 *
 * @author pc
 */
public class ApiTest {
    public ApiTest() {
        //定位到excel文件路径，File.separator 就是分割符，相当于 / ，这样便于在不同操作系统上使用
        String path = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator + "AutoExcel" + File.separator + "jiekou.xls";
        HttpClientUtils.openProy = false;   //代理开关，使用true或false打开关闭，如果没有开启代理软件请false,否则报错（开启后可以抓到接口数据）
        try {
            List<TestCase> list = ExcelUtils.getInstance().readExcel2Objects(path, TestCase.class);   //获取excel里的数据
            for (TestCase testCase : list) {                                                          //foreach查看数据
                if ("开启".equals(testCase.getRun())) {                                                   //如果run（是否开启）为是，则运行下面代码
                    System.out.print(testCase.getCaseName() + " \t");                                                      //输出该条用例详情
                    String Params = testCase.getParams().replaceAll("\"", "");   //当参数使用了excel生成随机数时，读取会产生双引号造成参数错误，去掉双引号
                    String result = "";
                    if ("get".equalsIgnoreCase(testCase.getType())) {
                        result = HttpClientUtils.doGet(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                    } else if ("post".equalsIgnoreCase(testCase.getType())) {
                        result = HttpClientUtils.doPost(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                    }
                    System.out.println(result);                                                         //输出请求返回数据
                    JSONObject jsonObject = JSON.parseObject(result);
                    //String success = jsonObject.get("success").toString();                              //若EXCEL定义成字符串，则需要这样转换
                    Object success = jsonObject.get("success");                                         //这里获取到的success是布尔型，所以在定义excel时类型也要是布尔
                    if (!success.equals(testCase.getDuanyan())) {
                        System.err.println("返回的：\"" + success + "\" 不等于预期的：\"" + testCase.getDuanyan() + "\"！！！");
                    }
                    assert success.equals(testCase.getDuanyan());                                       //断言获取到的 success 下的值是否等于excel中的值
                } else {
                    //System.out.println(testCase+"测试用例当前关闭");                                     //如果run不为“是”则输出
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ApiTest();
    }
}
