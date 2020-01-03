package DuoXianCheng;

import com.github.crab2died.annotation.ExcelField;

public class ExcelCase {
    @ExcelField(title = "用例名称",order=0)
    private String caseName;

    @ExcelField(title = "测试结果", order=1)
    private String result;

    @ExcelField(title = "数据库检查测试结果", order=2)
    private String dbresult;

    @ExcelField(title = "响应时间", order=3)
    private String responseTime;

    @ExcelField(title = "返回参数", order=4)
    private String returnParam;

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getReturnParam() {
        return returnParam;
    }

    public void setReturnParam(String returnParam) {
        this.returnParam = returnParam;
    }

    public String getDbresult() {
        return dbresult;
    }

    public void setDbresult(String dbresult) {
        this.dbresult = dbresult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
