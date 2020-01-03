package WanZheng.java.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Subject {
    public static void main(String[] args) {
        String test ="2342asfghgyu56asdasdaddddd";
        char onechar=test.charAt(0);
        System.out.println(onechar);


        Map<String, Integer> mapcount = new HashMap<String, Integer>();
        for (int i = 0; i < test.length(); i++) {
            String key =""+test.charAt(i);
            //如果存在
            if(mapcount.containsKey(key)) {
                int count =mapcount.get(key);
                mapcount.put(key, count+1);
            }else {
                //不存在就是1
                mapcount.put(key, 1);
            }
        }
        Set<String> keys = mapcount.keySet();
        for (String key : keys) {
            System.out.println(key+" "+mapcount.get(key));
        }
    }
}

