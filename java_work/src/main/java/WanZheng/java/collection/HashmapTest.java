package WanZheng.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;

public class HashmapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"hello");
        map.put(2,"hym");
        map.put(3,"lol");
        System.out.println(map.get(1));





        for (Object key:map.keySet()) {
            System.out.println(key.toString() +  "   "  +map.get(key));
        }

        Iterator<Map.Entry> ite = map.entrySet().iterator();
        while (ite.hasNext()){
            Map.Entry entry = ite.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
//
//        for (Map.Entry entry1 : map.entrySet()) {
//            System.out.println(map.entrySet());
//            System.out.println("key= " + entry1.getKey() + " and value= " + entry1.getValue());
//
//
//        }


        for (Object v:map.values()) {
            System.out.println("value= " + v);
        }




    }
}
