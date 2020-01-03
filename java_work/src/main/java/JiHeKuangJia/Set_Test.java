package JiHeKuangJia;

import java.sql.Connection;
import java.util.*;

/*
HashSet在存放数据（元素）的时候，自己会去重，但是存放对象的时候，需要定义去重规则
1.存数据（元素）
 */
class HashSet_ShuJu {
    public static void main(String[] args) {
        Set<String> set = new HashSet(); //定义一个集合
        set.add("Hello");      //先在集合中添加一个字符串
        set.add("World");
        set.add("Hello"); //由于String类中重写了hashcode和equals方法，用来比较指向的字符串对象所存储的字符串是否相等。所以这里的第二个Hello是加不进去的。
        boolean result = set.add("World");
        System.out.println(result);     //输出查看第二次操作是否成功，因为两个字符串对象通过equals方法比较相等，所以输出为false,未添加成功
        //说明：程序中，books集合两次添加的字符串对象明显不是一个对象（程序通过new关键字来创建字符串对象），
        //当使用==运算符判断返回false，使用equals方法比较返回true，所以不能添加到Set集合中，最后只能输出一个元素。
        System.out.println("集合长度为:" + set.size());
        System.out.println("集合元素为：" + set);
        //遍历时，若遍历完后iterator还需要使用，则用while循环，否则用for循环释放内存
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}

/*
存对象，需要在对象中定义去重的数据类型
 */
class HashSet_DuiXiang{
    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet();
        hashSet.add(new Person("张三",21));
        hashSet.add(new Person("李四",22));
        hashSet.add(new Person("王五",23));
        hashSet.add(new Person("张三",21));
        Iterator<Person> iterator =hashSet.iterator();
        while (iterator.hasNext()){
            Person p= iterator.next();
            System.out.println(p.getName()+"---"+p.getAge());
        }
    }

}

/*
LinkedHashSet链表是有序的set集合
 */
class LinkedHashSet_DuiXiang{
    public static void main(String[] args) {
        LinkedHashSet<Person> linkhashSet = new LinkedHashSet();
        linkhashSet.add(new Person("张三",21));
        linkhashSet.add(new Person("李四",22));
        linkhashSet.add(new Person("王五",23));
        linkhashSet.add(new Person("张三",21));
        Iterator<Person> iterator =linkhashSet.iterator();
        while (iterator.hasNext()){
            Person p= iterator.next();
            System.out.println(p.getName()+"---"+p.getAge());
        }
    }

}
/*
将ArrayList集合中的数据去重
 */
class HashSet_ListQuChong{
    public static void main(String[] args) {
        ArrayList<Person>  arrayList =new ArrayList<Person> ();
        LinkedHashSet linkhashSet = new LinkedHashSet();
        arrayList.add(new Person("张三",21));
        arrayList.add(new Person("李四",22));
        arrayList.add(new Person("王五",23));
        arrayList.add(new Person("赵六",24));
        arrayList.add(new Person("张三",21));
        Iterator iterator1 = arrayList.iterator();
        while (iterator1.hasNext()){
            linkhashSet.add(iterator1.next());
        }
        Iterator<Person> iterator2 = linkhashSet.iterator();
        while (iterator2.hasNext()){
            Person p=iterator2.next();
            //如果是list集合只有元素，直接用set转存即可，但如果有对象，则需要在对象中重写equals方法
            System.out.println(p.getName()+"---"+p.getAge());
        }
    }
}

/*
TreeSet可以对set集合中的元素进行指定顺序排序（直接存元素默认按字典顺序）
方法1
通过在对象中重写comparaTo比较方法来确定排序规则，这里按照年龄从大到小排序，年龄相同按字符串字典顺序排序
 */
class TreeSet_DuiXiang{
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.add(new Person("张三",21));
        treeSet.add(new Person("李四",22));
        treeSet.add(new Person("王五",23));
        treeSet.add(new Person("张三",21));
        treeSet.add(new Person("赵六",21));
        Iterator<Person> iterator =treeSet.iterator();
        while (iterator.hasNext()){
            Person p= iterator.next();
            System.out.println(p.getName()+"---"+p.getAge());
        }
    }
}

/*
方法2，自定义比较器，按自定义方法来实现比较
给定字符串，按照字符串长度排序
 */
class TreeSet_PaiXu{
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>(Collections.reverseOrder()); //加入自定义排序
        treeSet.add("aaaa");
        treeSet.add("aksjdlakj");
        treeSet.add("zzz");
        treeSet.add("fkasj");
        treeSet.add("cba");
        treeSet.add("abc");
        Iterator<String> iterator =treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

class ComparetorByLength implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String s1 =(String)o1;
        String s2 =(String)o2;
        int temp =s1.length()-s2.length();
        return temp==0?s1.compareTo(s2):temp;  //字符串长度相同按字典排序
    }
}
