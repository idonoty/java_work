package WanZheng.java.utils.httpclient;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import WanZheng.java.utils.correlation.CorrelationUtils;
import WanZheng.java.utils.httpclient.check.CheckPointUtils;
import WanZheng.java.utils.httpclient.check.JsonCheckResult;
import WanZheng.java.utils.jdbc.DbCheck;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.crab2died.ExcelUtils;


/**
 * 接口测试主类
 *
 * @author pc
 */
public class ApiTest {

    private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private static String getCurrentTime() {  //生成时间作为测试报告名称
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        String time = formatter.format(date);
        return time;
    }

    public static void main(String[] args) {
        testcase(false);

    }

    public static void testcase(boolean openProy) {
        HttpClientUtils.openProy = false; //是否走代理开关
        //第一个是读取的excel路径，第二个是写入的路径
        String path = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator + "AutoExcel" + File.separator + "jiekou.xls";
        String path2 = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator + "AutoExcel" + File.separator +
                getCurrentTime() + ".xlsx";
        try {
            List<TestCase> list = ExcelUtils.getInstance().readExcel2Objects(path, TestCase.class);
            List<TestCaseResult> XRexcel = new ArrayList<TestCaseResult>();       //定义集合框架，为写入数据做准备
            List<ParameterBean> listParameters = ExcelUtils.getInstance().readExcel2Objects(path, ParameterBean.class, 1);  //读取excel第二张表（测试多用户用到）

//            for (ParameterBean parameterBean : listParameters) {
//                //添加关联数据，将第二张表的参数添加到map集合中关联
//                System.out.println(parameterBean);
//                System.out.println(listParameters);
//                CorrelationUtils.addCorrelation(parameterBean);
                for (TestCase item : list) {
                    TestCase testCase = new TestCase();
                    //复制list的对象，但不复制属性，这样单接口多次关联就不会失效（否则上次关联的数据（属性）会保存，第二次就不是${}格式了，无法关联）
                    BeanUtils.copyProperties(testCase, item);
                    if ("开启".equals(testCase.getRun().trim())) {   //判断excel接口状态是否为开启，是的话运行下面代码
                        // 关联替换,将关联符号替换成对应变量
                        System.out.println(testCase);
                        CorrelationUtils.doBefore_replace(testCase);
                        String result = null;
                        String Params = testCase.getParams();//replaceAll("\"", "");     //去掉代码读取excel单元格拼接产生的引号（excel生成随机数）这种会去掉所有引号
                        //改用下面的方法处理引号，如果字符串第一个和最后一个是引号，就去掉第一个和最后一个字符
                        if (String.valueOf(Params.charAt(0)).equals("\"") && String.valueOf(Params.charAt(Params.length() - 1)).equals("\"")) {
                            Params = Params.substring(1, Params.length() - 1);
                        }
                        if ("get".equalsIgnoreCase(testCase.getType().trim())) {                        // get 请求
                            result = HttpClientUtils.doGet(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                            System.out.println(testCase.getUrl() + testCase.getInterFace() + Params);
                        } else if ("post".equalsIgnoreCase(testCase.getType().trim())) {                        // post 请求
                            result = HttpClientUtils.doPost(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                            System.out.println(testCase.getUrl() + testCase.getInterFace() + Params);
                        } else if ("postjson".equalsIgnoreCase(testCase.getType().trim())) {                        // post 请求
                            result = HttpClientUtils.doPostJson(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                            System.out.println(testCase.getUrl() + testCase.getInterFace() + Params);
                        }
                        //判断返回结果是否为空，再处理json组
                        //处理返回结果为json组（数据量较大，分多组json）的情况，去掉前后的中括号，不然在检查点时无法读取json数据，会报错
                        if (!"".equals(result) && result != null && result.startsWith("[") && result.endsWith("]")) {
                            result = result.substring(1, result.length() - 1);
                        } else if ("".equals(result) || result == null) {
                            System.out.print("\"" + testCase.getCaseName() + "\"接口返回结果为空  ");
                        }
                        System.out.println(result);
                        System.out.println("接口响应时间: " + HttpClientUtils.allTime + "ms");    //allTime是HttpClientUtils开头中定义的静态全局变量
                        JsonCheckResult jsonCheckResult = CheckPointUtils.check(result, testCase.getCheckpoint());  //对比EXCEL中的检查点
                        System.out.println(jsonCheckResult.getMsg() + " 判断依据: " + testCase.getCheckpoint());           //输出对比成功或者失败
                        CorrelationUtils.addCorrelation(result, testCase);                  //关联接口返回参数
                        CorrelationUtils.addSqlCorrelation(testCase);                       //关联数据库查询语句
                        CorrelationUtils.doafter_replace(testCase);                         //去除数据库检查语句引号
                        String dbcheckResult = DbCheck.check(testCase);       //对比EXCEL中的数据库检查点
                        System.out.println(dbcheckResult + " 判断依据: " + testCase.getDbcheckpoint());        //输出数据库对比成功或者失败
                        TestCaseResult testCaseResult = new TestCaseResult();   //将TestCaseResult实例化，准备使用set方法写入变量
                        BeanUtils.copyProperties(testCaseResult, testCase);
                        testCaseResult.setResult(jsonCheckResult.getMsg());     //写入检查点是否成功
                        testCaseResult.setReturnParam(result);                  //将接口返回参数写入
                        testCaseResult.setDbresult(dbcheckResult);              //写入数据库检查点是否成功
                        testCaseResult.setResponseTime(HttpClientUtils.allTime + "ms");  //写入接口响应时间
                        //System.out.println(testCaseResult);
                        XRexcel.add(testCaseResult);                            //把写好的数据加入到前面定义的集合框架内
                        System.out.println("--------------------------------------------------------------------------------");
                    } else {
                        //System.out.println(testCase + "测试用例当前关闭");
                    }
                }

            list.clear();
            // 内存对象清空
            CorrelationUtils.clear();
            // 写excel
            ExcelUtils.getInstance().exportObjects2Excel(XRexcel, TestCaseResult.class, path2);  //将写入TestCaseResult的数据写入到excel文件中
            //发邮件
            //EmailUtils.sendEmailsWithAttachments("apitest测试结果", "请查收", path2);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
        }
        System.out.println("测试完毕");
    }

}
