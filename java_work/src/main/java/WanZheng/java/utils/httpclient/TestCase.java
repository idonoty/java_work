package WanZheng.java.utils.httpclient;

import com.github.crab2died.annotation.ExcelField;

public class TestCase {

	@ExcelField(title = "状态")
	private String run;

	public String getMultiScene() {
		return multiScene;
	}

	public void setMultiScene(String multiScene) {
		this.multiScene = multiScene;
	}

	@ExcelField(title = "多场景")
	private String multiScene;

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

	@ExcelField(title = "检查点")
	private String checkpoint;

	@ExcelField(title = "关联")
	private String correlation;

	@ExcelField(title = "数据库检查sql")
	private String dbchecksql;

	@ExcelField(title = "数据库检查点")
	private String dbcheckpoint;

	@ExcelField(title = "数据库关联")
	private String sqlCorrelation;

	public String getSqlCorrelation() {
		return sqlCorrelation;
	}

	public void setSqlCorrelation(String sqlCorrelation) {
		this.sqlCorrelation = sqlCorrelation;
	}

	public String getInterFace() { return interFace; }

	public void setInterFace(String interFace) { this.interFace = interFace; }

	public String getDbchecksql() {
		return dbchecksql;
	}

	public void setDbchecksql(String dbchecksql) {
		this.dbchecksql = dbchecksql;
	}

	public String getDbcheckpoint() {
		return dbcheckpoint;
	}

	public void setDbcheckpoint(String dbcheckpoint) {
		this.dbcheckpoint = dbcheckpoint;
	}

	public String getCorrelation() {
		return correlation;
	}

	public void setCorrelation(String correlation) {
		this.correlation = correlation;
	}

	public String getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(String checkpoint) {
		this.checkpoint = checkpoint;
	}

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

    @Override
    public String toString() {
        return "TestCase{" +
                "run='" + run + '\'' +
                ", multiScene='" + multiScene + '\'' +
                ", caseName='" + caseName + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", interFace='" + interFace + '\'' +
                ", params='" + params + '\'' +
                ", header='" + header + '\'' +
                ", checkpoint='" + checkpoint + '\'' +
                ", correlation='" + correlation + '\'' +
                ", dbchecksql='" + dbchecksql + '\'' +
                ", dbcheckpoint='" + dbcheckpoint + '\'' +
                ", sqlCorrelation='" + sqlCorrelation + '\'' +
                '}';
    }

}
