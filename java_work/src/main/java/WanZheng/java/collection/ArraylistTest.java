package WanZheng.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.*;

public class ArraylistTest {
    public static void main(String[] args) {
        List arrayList = new ArrayList();


        arrayList.add("hello");
        arrayList.add("hym");
        arrayList.add(1);


        for (Object arr : arrayList) {
            System.out.println(arr);
        }
        Iterator ite = arrayList.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
    }
    }


}
