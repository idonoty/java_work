package JiHeKuangJia;

import java.util.*;

//list存取数据
class ArrayList_ShuJu {
    public static void main(String[] args) {
        List<String> list = new ArrayList();   //前面加<String>说明只能add字符串格式，不加则是Object格式
        list.add("Hello");
        list.add("World");
        list.add("hello");
        list.add("1");
        System.out.println("集合长度为:" + list.size());
        System.out.println("集合元素为：" + list);
        list.add(1, "sas");
        System.out.println("集合索引为1的元素为：" + list.get(1));
        //第一种遍历方法使用foreach遍历List
        for (String A : list) {           //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(A);
        }
        //子集合
        System.out.println("对应位置的子集合" + list.subList(0, 3));
        Iterator iterator = list.iterator(); //和for循环一样的功能，遍历元素，但是迭代过程中无法修改集合
        while (iterator.hasNext()) {  //当存在下一个元素时持续循环
            System.out.println(iterator.next());
        }
        ListIterator listIterator = list.listIterator();  //List特有，可在遍历时修改集合
        while (listIterator.hasNext()) {
            Object o = listIterator.next();
            if (o == "World") {
                listIterator.add("哈哈哈");
            }
            System.out.println(o);
        }
        System.out.println(list);

    }
}

//list存取对象
class ArrayList_DuiXiang{
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList(4);
        arrayList.add(new Person("张三",21));
        arrayList.add(new Person("李四",22));
        arrayList.add(new Person("王五",23));
        arrayList.add(new Person("赵六",24));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            //System.out.println(iterator.next()); //直接next无法获取name和age，只能得到person的hash
            //这样也不行，一个循环不能同时两个next
            //System.out.println(((Person)iterator.next()).getName()+""+((Person)iterator.next()).getAge());
            Person p= (Person) iterator.next();
            System.out.println(p.getName()+"--"+p.getAge());
        }
    }
}

/*
使用LinkedList模拟堆栈和队列
堆栈：先添加的元素，后出来,也就是先添加的元素，删除时最后删掉
队列：先添加的元素先出来，也就是先添加的元素，删除时最先删掉
 */
class LinkedList_DuiZhan {
    LinkedList addDate(LinkedList link, Object o) {
        link.addFirst(o);
        return link;
    }

    void getDate(LinkedList link) {
        for (int i = 0; link.isEmpty()==false ; i++) {  //当集合未空是false时，持续循环
            System.out.println(link.removeFirst());
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList_DuiZhan link = new LinkedList_DuiZhan();
        link.addDate(linkedList, "abc1");
        link.addDate(linkedList, "abc2");
        link.addDate(linkedList, "abc3");
        link.getDate(linkedList);
    }
}

class LinkedList_DuiLie {
    LinkedList addDate(LinkedList link, Object o) {
        link.addFirst(o);
        return link;
    }

    void getDate(LinkedList link) {
        for (int i = 0; link.isEmpty()==false ; i++) {  //当集合未空是false时，持续循环
            System.out.println(link.removeLast());
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList_DuiLie link = new LinkedList_DuiLie();
        link.addDate(linkedList, "abc1");
        link.addDate(linkedList, "abc2");
        link.addDate(linkedList, "abc3");
        link.getDate(linkedList);
    }
}
