package JiHeKuangJia;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.awt.image.ImageWatched;

import java.util.*;


class Hashmap_ShuJu {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(0, "hello");
        map.put(1, "hi");
        map.put(2, "yyc");
        System.out.println(map.keySet());   //map.keySet() 则是获取map中的key值，即[0, 1, 2]
        System.out.println(map.get(1));   //map.get(*) 则是获取map中的value值，*是key（类似于索引），获取key对应的value

        for (Object AA : map.keySet()) {
            System.out.println(AA.toString() + ":" + map.get(AA));
        }
//        Iterator<Map.Entry> BB = map.entrySet().iterator();
//         Map.Entry entry =BB.next();
//        System.out.println("key="+ entry.getKey() + "  value=" +entry.getValue());
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        map.forEach((key, value) -> System.out.println("key= " + key + " and value= " + value));
    }
}

class HashMap_CiShuJiSuan {
    public static void main(String[] args) {
        String AA = "214415121asssawqmfaskqwdssaczswqdsa";
        char suoyin = AA.charAt(0);  //获取字符串里面第一个元素
        System.out.println(suoyin);

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < AA.length(); i++) {
            String key = "" + AA.charAt(i);
            //如果存在
            if (map.containsKey(key)) {
                int count = map.get(key);
                map.put(key, count + 1);
            } else {
                //不存在就是1
                map.put(key, 1);
            }
        }
        System.out.println(map.keySet());
        Set<String> keys = map.keySet();  //
        for (String key : keys
                ) {
            System.out.println(key + " " + map.get(key));

        }
    }
}

