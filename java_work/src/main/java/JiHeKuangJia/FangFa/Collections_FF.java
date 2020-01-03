package JiHeKuangJia.FangFa;

/*
此文件中包换collectionS（集合）的各种操作方法
更多具体方法看jdk操作文档
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class paixu{
    public static void main(String[] args) {
        List<String> list =new ArrayList();
        list.add("abcd");
        list.add("abcdef");
        list.add("abcde");
        list.add("bcde");
        list.add("zzze");
        list.add("abcde");
        list.add("cbzxa");
        System.out.println(list);
        Collections.sort(list); //对集合进行排序（编码表）
        System.out.println(Collections.max(list)+"默认获取最大元素");
        System.out.println(list +"排序");
        System.out.println(Collections.binarySearch(list,"abcde")+"获取排序后的指定元素位置");
        System.out.println(Collections.binarySearch(list,"zzzzz")+"获取不到则返回如果有该元素，它应该在什么位置");
        Collections.reverse(list); //对现有顺序进行反向排序
        System.out.println(list +"反排序");
        mySort(list); //自己写的排序方法（冒泡循环）
        System.out.println(list + "自己排序");
        Collections.sort(list,new ComparatorByLength());
        System.out.println(list + "自己按字符串长度排序");
        System.out.println(Collections.max(list,new ComparatorByLength()) +"按自己的排序方法获取最大元素");
    }
    //自己写一个排序方法
    public static  void mySort(List<String> list){
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size()-1;j++){
                if (list.get(j).compareTo(list.get(j+1))>0){
//                    String temp = list.get(j);
//                    list.set(j,list.get(j+1));
//                    list.set(j+1,temp);
                    Collections.swap(list,j,j+1); //对集合两个位置的元素进行互换
                }
            }
        }
    }
    //上面的只能对Sting，实际应该是，只要继承了排序类的都可以进行比较（只要能用compateTo方法即可）
    public static <T extends Comparable<? super T>> void mySort2(List<T> list){
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size()-1;j++){
                if (list.get(j).compareTo(list.get(j+1))>0){
                    T temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }

}