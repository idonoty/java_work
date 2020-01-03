package WanZheng.java.utils.httpclient.check;

public enum JsonCheckResult {
    SUCCESS(true, "检查点检查成功"),
    FAIL(false, "检查点检查失败"),
    SKIP(false, "检查点为空或接口返回不是json格式"),
    ISVALID(true, "不是json格式数据"),
    DBFAIL(false, "数据库检查失败"),
    EMPTY(false, "未找到检查点对应的json-Key");

    private boolean result;
    private String msg;

    private JsonCheckResult(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
