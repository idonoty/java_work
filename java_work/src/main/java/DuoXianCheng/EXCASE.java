package DuoXianCheng;

import com.github.crab2died.annotation.ExcelField;

public class EXCASE {
    @ExcelField(title = "测试结果", order=1)
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
