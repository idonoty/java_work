package JiHeKuangJia;

public class Person implements Comparable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode()+age;  //重写hashCode方法，返回姓名和年龄的哈希值
    }

    @Override
    public boolean equals(Object obj) {
        Person p =(Person)obj;  //强转Object类型
        return this.name.equals(p.name) && this.age==p.age;  //通过上方hash值判断后，还要判断内容是否相同
    }

    @Override
    public int compareTo(Object o) {  //TreeSet需要重写比较方法来定义排序规则（排序方法1，若对象类改不了，则需要用方法2）
        Person p= (Person) o;
        int temp= this.getAge()-p.getAge();
        return temp==0?p.name.compareTo(this.name):temp;
    }
}
