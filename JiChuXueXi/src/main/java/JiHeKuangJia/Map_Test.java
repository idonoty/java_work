package JiHeKuangJia;

import sun.security.util.PendingException;

import java.util.*;

class Map_YuanSu{
    public static void main(String[] args) {
        Map<Object, String> map= new HashMap<>();
        //添加
        System.out.println(map.put(1,"老王"));  //null
        System.out.println(map.put(1,"老李"));  //老王
        map.put(3,"啊倒");
        map.put(2,"asd");
        System.out.println(map.remove(3)); //返回value后删除键值对；
        System.out.println(map.remove(2,"asd")); //删除后键值对正确返回true，键值对填写错误返回false，
        System.out.println(map.containsKey(2)); //是否包含指定key
        System.out.println(map.containsValue("老李"));//是否包含指定value
        System.out.println(map.isEmpty()); //是否为空，为空返回true
        System.out.println(map.get(1));   //取key为1的value
        map.put(7,"阿斯弗");
        map.put(6,"方法法国");
        map.put(8,"哈哈");
        map.put(0,"哈哈");
        System.out.println(map);
        System.out.println(map.keySet());  //返回map中value的set视图
        System.out.println(map.values());  //返回map中value的collection视图
        System.out.println(map.entrySet());//返回map中包含映射(即键值对，Key和它的映射value)的Set视图,输出时和直接输出map效果一致，但是可以用迭代器。
        for (Object AA:map.keySet()) {  //遍历map集合
            System.out.println("key:"+AA+" --- value:"+map.get(AA));
        }
        //或者用迭代器遍历
        Iterator<Object> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Object key=iterator.next();
            Object value=map.get(key);
            System.out.println("key:"+key+" ^^^ value:"+value);  //若无字符串，则加号不能用于Object类，需要强转成String
        }
        //直接迭代键值对，map自带方法
        Set<Map.Entry<Object, String>> enSet =map.entrySet();
        Iterator<Map.Entry<Object, String>> iterator2=enSet.iterator();
        while(iterator2.hasNext()){
            //System.out.println(iterator2.next());  //这样会直接迭代输出所有键值对，若要分别取出键值则按以下方法
            Map.Entry<Object, String> map2= iterator2.next();
            Object key =map2.getKey();
            Object value =map2.getValue();
            System.out.println(key+" :: "+value);
        }
    }
}
//HashMap存元素和map存元素一样，反正键都是唯一的，HashMap存对象需要重写唯一性判断方法
class HashMap_DuiXiang{
    public static void main(String[] args) {
        HashMap<Person,String> hashMap = new HashMap<>();
        hashMap.put(new Person("赵六",21),"湖南");
        hashMap.put(new Person("李四",20),"新疆");
        hashMap.put(new Person("王五",22),"重庆");
        hashMap.put(new Person("张三",31),"河南");
        hashMap.put(new Person("王五",22),"成都");
        //和HashSet一样，同key在对象中需要重写hashCode方法和equals方法才能去重
        hashMap.entrySet().stream().forEach(personStringEntry -> {
            Person key =personStringEntry.getKey();
            System.out.println(key.getAge()+":"+key.getName() +":" + personStringEntry.getValue());
        });
//上面使用 lamda表达式 可以做到下面代码一样的效果
//        Set<Map.Entry<Person, String>> set=hashMap.entrySet();
//        Iterator iterator =set.iterator();
//        while (iterator.hasNext()){
//            Map.Entry map = (Map.Entry) iterator.next();
//            Person key = (Person) map.getKey();
//            String value = (String) map.getValue();
//            System.out.println(key.getAge()+":"+key.getName()+"--"+value);
//        }
    }
}

//排序用TreeMap,对象中重写compareTo排序方法
class TreeMap_DuiXiangPaiXu{
    public static void main(String[] args) {
        TreeMap<Person,String> treeMap =new TreeMap();
        treeMap.put(new Person("赵六",21),"湖南");
        treeMap.put(new Person("李四",20),"新疆");
        treeMap.put(new Person("王五",22),"重庆");
        treeMap.put(new Person("张三",31),"河南");
        treeMap.put(new Person("王五",22),"成都");
        for(Person key:treeMap.keySet()){
            System.out.println(key.getAge()+"-"+key.getName()+"--"+treeMap.get(key));
        }
    }
}


