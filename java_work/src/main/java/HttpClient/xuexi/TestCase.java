package HttpClient.xuexi;

import com.github.crab2died.annotation.ExcelField;


public class TestCase {
	//定义的变量首字母不能大写（会报错），因为读取excel的时候getRun会自动大写
	@ExcelField(title = "状态")
	private String run;

	@ExcelField(title = "用例名称")
	private String caseName;

	@ExcelField(title = "类型")

	private String type;

	@ExcelField(title = "地址")
	private String url;

	@ExcelField(title = "接口")
	private String interFace;

	@ExcelField(title = "参数")
	private String params;

	@ExcelField(title = "头部")
	private String header;

	@ExcelField(title = "是否需要cookie")
	private String cookie;

	@ExcelField(title = "检查点")
	private Boolean duanyan;

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInterFace() {
		return interFace;
	}

	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public Boolean getDuanyan() {
		return duanyan;
	}

	public void setDuanyan(Boolean duanyan) {
		this.duanyan = duanyan;
	}

	@Override
	public String toString() {
		return "TestCase{" +
				"run='" + run + '\'' +
				", caseName='" + caseName + '\'' +
				", type='" + type + '\'' +
				", url='" + url + '\'' +
				", interFace='" + interFace + '\'' +
				", params='" + params + '\'' +
				", header='" + header + '\'' +
				", cookie='" + cookie + '\'' +
				", duanyan='" + duanyan + '\'' +
				'}';
	}
}

