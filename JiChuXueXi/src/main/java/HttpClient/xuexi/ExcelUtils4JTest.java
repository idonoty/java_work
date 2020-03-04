package HttpClient.xuexi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;

public class ExcelUtils4JTest {

    public static void main(String[] args) {
        String path = File.separator + "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "Desktop" + File.separator + "jiekou.xls";
        try {
            //读取
            List<TestCase> list = ExcelUtils.getInstance().readExcel2Objects(path, TestCase.class);
            for (TestCase testCase : list) {
                System.out.println(testCase);
            }
            //写
            //ExcelUtils.getInstance().exportObjects2Excel(list, StudentExcel.class, "d:/result.xlsx");
        } catch (InvalidFormatException | Excel4JException | IOException e) {
            e.printStackTrace();
        }
    }


}
