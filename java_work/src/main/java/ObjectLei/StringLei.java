package ObjectLei;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

public class StringLei {
    public static void main(String[] args) {
        String str = "abcdefg";  //共7个字符

        //查看字符串字符属性
        int str_len = str.length();  //获取字符串内字符的长度（个数）
        char str_char = str.charAt(2); //根据位置获取字符
        //可以通过.indexOf("*")是否等于-1判断字符串中有没有 * 字符,没有该字符结果为-1
        int str_index = str.indexOf("X"); //获取字符在字符串中第一次出现的位置
        int str_index2 = str.indexOf("c", 3);  //从第3个字符开始（包括3），往后查找“c”第一次出现的位置
        int str_last = str.lastIndexOf("c"); //从后往前数，获取字符在字符串中第一次出现的位置
        int str_last2 = str.lastIndexOf("c", 8);  //从第8个字符开始（包括3），往-前-查找“c”第一次出现的位置
        System.out.println(str_last2);

        //获取字符串中的部分字符串（子串）
        System.out.println(str.substring(1));   //从索引为1开始，往后形成子串
        System.out.println(str.substring(2, 4));  //从索引为2的字符开始，到索引为4的字符结束形成子串（包含2，不包含4）

        //字符串转换
        //切割成字符串数组
        String str2 = "小李，小王，小张";
        String[] arr = str2.split("，"); //通过填写的分隔字符切割成单个字符并组成数组
        for (String a : arr) {
            System.out.println(a);
        }
        String str3 = "大李.大王.大张";
        String[] arr2 = str3.split("\\.");  //如果要用 . 分隔，必须加上 \\ 转义
        for (String b : arr2) {
            System.out.println(b);
        }
        //切割成单个字符
        char[] ch = str2.toCharArray();
        for (char a : ch) {
            System.out.println(a);
        }
        //将字符串转换成单个字节
        String str4 = "Aa王";
        byte[] by = str4.getBytes();
        for (byte a : by) {
            System.out.println(a);
        }
        //转换英文大小写
        System.out.println("Abc啊".toUpperCase()); //大写
        System.out.println("Abc啊".toLowerCase()); //小写
        //将字符串内容进行替换
        String str5 = "abc,hhhooo";
        System.out.println(str5.replace("abc", "哈哈哈"));
        //去掉字符串两端空格
        System.out.println("=" + " a a ".trim() + "=");
        //其他类型转换成字符串类型 String.valueOf()
        System.out.println(String.valueOf(4) + 1);

        //字符串判断
        //忽略大小写判断
        String a = "aBc";
        System.out.println(a.equals("ABC".toLowerCase())); //这种需要分别转换大写和小写，若原字符串大小写都有会出错
        System.out.println(a.equalsIgnoreCase("ABC")); //这种是完全忽略大小写
        //判断字符串是否包含某个字符串
        System.out.println(a.contains("Bc"));
        //判断字符串是否以某个字符开头/结尾
        String S = "AutoTest.xls";
        System.out.println(String.valueOf(S.charAt(0)));
        System.out.println(String.valueOf(S.charAt(0)).equals("Auto")); //这个只能用第一个字符，不能用于多个字符
        System.out.println(S.startsWith("Auto"));
        System.out.println(S.endsWith(".xls"));

        //字符串比较，根据编码表对应的字节比较，若字符串相等则为0，大于为正数，小于为负数
        System.out.println("bc".compareTo("ab"));  // 1
        System.out.println("哈哈".compareTo("哦哦")); //-30
        System.out.println("一二三".compareTo("一二三"));  // 0
        //字符串排序
        String shuzu[] = {"bac", "hhha", "啊是", "aa", "瞬间", "aa", "a", "b"};
        for (int i = 0; i < shuzu.length; i++) {
            for (int j = 0; j < shuzu.length - 1; j++) {
                if (shuzu[j].compareTo(shuzu[j + 1]) > 0) {
                    String temp;
                    temp = shuzu[j];
                    shuzu[j] = shuzu[j + 1];
                    shuzu[j + 1] = temp;
                }
            }
        }
        System.out.print("{");
        for (String A : shuzu) {
            System.out.print(A + " ");
        }
        System.out.println("}");

        //获取字串在一个字符串中出现的次数
        //分隔方法
        String s = "哈哈abcaskbac哈哈kfabcas哈哈fagak哈哈labckg哈哈iabc哈哈";
        String s_z = "哈哈";
        String[] sarr = s.split(s_z); //通过填写的分隔字符切割成单个字符并组成数组
        if (s.lastIndexOf(s_z) == s.length() - s_z.length()) {   //当子串作为结尾时，需要做出判断，因为结尾空格不算
            System.out.println(sarr.length);
        } else {
            System.out.println(sarr.length - 1); //分隔的数组会比分割符多1
        }
        //也可以使用查询字符串第一次出现的位置，下一次以查询过的位置开始再次查询

        //查询两个字符串中，相同且最大长度的子串
        String o="abcdeaaaaddddccccza1111b";
        String p="asdabcdeafasfasfaf333";
        //思路：查看一个字符串是否包含另一个，若不包含，则另一个字符串减1位，直到包含为止
        String max,min;
        max=(o.length()>p.length())?o:p;  //三元表达式将长的字符串赋值给max
        min=(max==o)?p:o;
        System.out.println("max:"+max+"\n"+"min:"+min);
        for (int i = 0; i <min.length() ; i++) {
            for (int A=0,B=min.length()-i;B <=min.length();A++,B++){ //第一次A=0，B=最大长度，然后B减少，A增加，当B大于最大长度时，进行上一个for循环
                String sub = min.substring(A,B);
                if (max.contains(sub)){
                    System.out.println(sub);
                    return;}
            }
        }


    }
}
