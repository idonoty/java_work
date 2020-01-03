package DuoXianCheng;


import WanZheng.java.utils.correlation.CorrelationUtils;
import WanZheng.java.utils.httpclient.HttpClientUtils;
import WanZheng.java.utils.httpclient.TestCase;
import WanZheng.java.utils.httpclient.check.CheckPointUtils;
import WanZheng.java.utils.httpclient.check.JsonCheckResult;
import WanZheng.java.utils.jdbc.DbCheck;
import com.github.crab2died.ExcelUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Thread_EXCEL {
    static int i;
    static List<EXCASE> A= new ArrayList();

    public static void main(String[] args) {
        {
            for ( i = 0; i <10; i++) {
                System.out.println("开启线程" + i);
                new Thread("线程" + i) {
                    public void run() {
                        HttpClientUtils.openProy = false; //是否走代理开关
                        //第一个是读取的excel路径，第二个是写入的路径
                        String path = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator + "AutoExcel" + File.separator + "jiekou.xls";
                        String path2 = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator + "AutoExcel" + File.separator +"111.xlsx";
                        try {
                            List<TestCase> list = ExcelUtils.getInstance().readExcel2Objects(path, TestCase.class);
                            for (TestCase testCase : list) {
                                // 如果开启
                                if ("开启".equals(testCase.getRun())) {   //判断excel状态是否为开启，是的话运行下面代码
                                    // 关联替换
                                    System.out.println(testCase.getCaseName());
                                    CorrelationUtils.doBefore_replace(testCase);
                                    String result = null;
                                    String Params = testCase.getParams().replaceAll("\"", "");     //去掉代码读取excel单元格拼接产生的引号（excel生成随机数）
                                    if ("get".equalsIgnoreCase(testCase.getType())) {                        // get 请求
                                        result = HttpClientUtils.doGet(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                                        System.out.println(testCase.getUrl() + testCase.getInterFace() + Params);
                                    } else if ("post".equalsIgnoreCase(testCase.getType())) {                        // post 请求
                                        result = HttpClientUtils.doPost(testCase.getUrl(), testCase.getInterFace(), Params, testCase.getHeader());
                                        System.out.println(testCase.getUrl() + testCase.getInterFace() + Params);
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
//                                    ExcelCase excelCase = new ExcelCase();
//                                    excelCase.setCaseName(testCase.getCaseName());
//                                    excelCase.setResult(jsonCheckResult.getMsg());     //写入检查点是否成功
//                                    excelCase.setReturnParam(result);                  //将接口返回参数写入
//                                    excelCase.setDbresult(dbcheckResult);              //写入数据库检查点是否成功
//                                    excelCase.setResponseTime(HttpClientUtils.allTime + "ms");  //写入接口响应时间
//                                    XRexcel.add(excelCase);                            //把写好的数据加入到前面定义的集合框架内
                                    String B=testCase.getCaseName()+"  "+jsonCheckResult.getMsg()+"  "+dbcheckResult+"  "+HttpClientUtils.allTime + "ms";
                                    EXCASE E = new EXCASE();
                                    E.setResult(B);
                                    A.add(E);


                                } else {
                                    //System.out.println(testCase + "测试用例当前关闭");
                                }
                            }
                            Thread.sleep(4000);
                            ExcelUtils.getInstance().exportObjects2Excel(A, EXCASE.class, path2);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("测试完毕");
                    }
                }.start();
            }
        }
    }}
