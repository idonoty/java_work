package WanZheng.java.utils.excel4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;

public class ExcelUtils4JTest {

    public static void main(String[] args) {
        String path=System.getProperty("/Users/onepiece/Desktop/teach/src/main/resources/test.xlsx");
        try {
            //读取
            List<StudentExcel> list = ExcelUtils.getInstance().readExcel2Objects(path, StudentExcel.class);
            for (StudentExcel studentExcel : list) {
                System.out.println(studentExcel);
            }
            //写
            //ExcelUtils.getInstance().exportObjects2Excel(list, StudentExcel.class, "d:/result.xlsx");
        } catch (InvalidFormatException | Excel4JException | IOException e) {
            e.printStackTrace();
        }
    }


}
