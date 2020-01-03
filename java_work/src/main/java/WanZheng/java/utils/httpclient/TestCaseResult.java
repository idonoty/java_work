package WanZheng.java.utils.httpclient;

import com.github.crab2died.annotation.ExcelField;

/**
 * 结果
 * @author pc
 *
 */
public class TestCaseResult extends TestCase{
	@ExcelField(title = "测试结果", order=1)
	private String result;
	
	@ExcelField(title = "数据库检查测试结果", order=2)
	private String dbresult;

	@ExcelField(title = "响应时间", order=3)
	private String responseTime;

	@ExcelField(title = "返回参数", order=4)
	private String returnParam;

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
