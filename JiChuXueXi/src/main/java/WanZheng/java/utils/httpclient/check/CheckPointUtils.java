package WanZheng.java.utils.httpclient.check;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.googlecode.aviator.AviatorEvaluator;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckPointUtils {
    public static boolean openLog = false;

    public CheckPointUtils() {
    }

    public static JsonCheckResult check(String jsonString, String check) {
        if (check != null && jsonString != null && !"null".equals(jsonString)) {
            if (!JSON.isValid(jsonString)) {
                return JsonCheckResult.SKIP;
            } else {
                //下面|\\|\\| 第一个|是或的意思，\\|是将|转成字符串
                String[] check_array = check.split("&&|\\|\\|");  //意思是用&& 或者 || 做分割符
                int keycount = 0;
                Map<String, Object> env = new LinkedHashMap();
                String[] var5 = check_array;
                int var6 = check_array.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String curentcheck = var5[var7];
                    String oldcheck = curentcheck;
                    String[] values = curentcheck.split("=|>|<|>=|<=|==");
                    String key = values[0];
                    String value = values[values.length - 1];
                    Object checkValue = JSONPath.read(jsonString, key);
                    String newKey = "data" + keycount++;
                    curentcheck = curentcheck.replace(key, newKey);
                    if (checkValue != null) {
                        env.put(newKey, checkValue);
                    }

                    if (checkValue instanceof String) {
                        String newValue = covertToAviatorString(value.toString());
                        curentcheck = replaceLast(curentcheck, value, newValue);
                    }

                    if (curentcheck.contains("=") && !curentcheck.contains(">=") && !curentcheck.contains("<=") & !curentcheck.contains("==")) {
                        curentcheck = curentcheck.replace("=", "==");
                    }

                    check = check.replace(oldcheck, curentcheck);
                    if (openLog) {
                        System.out.println(curentcheck + " map " + env);
                    }
                }

                if (openLog) {
                    System.out.println("check  " + check + " map " + env);
                }

                Boolean result = true;
                if (env.isEmpty()) {
                    return JsonCheckResult.EMPTY;
                } else {
                    result = (Boolean)AviatorEvaluator.execute(check, env);
                    if (result) {
                        return JsonCheckResult.SUCCESS;
                    } else {
                        return JsonCheckResult.FAIL;
                    }
                }
            }
        } else {
            return JsonCheckResult.SKIP;
        }
    }

    private static String covertToAviatorString(String str) {
        return "'" + str + "'";
    }

    private static String replaceLast(String text, String strToReplace, String replaceWithThis) {
        return text.replaceFirst("(?s)" + strToReplace + "(?!.*?" + strToReplace + ")", replaceWithThis);
    }

    public static void main(String[] args) {
        String test = "{\"msg\":\"登录成功\",\"uid\":\"DAD3483647A94DBDB174C4C036CA8A80\",\"code\":\"1\",\"code2\":\"2\",\"code3\":\"3\"}";
        String expression = "code=1&&code2>=4||code3>=2";
        System.out.println(check(test, expression));
    }
}
