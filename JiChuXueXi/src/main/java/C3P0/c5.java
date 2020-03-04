package C3P0;
import Mysql.LianJie_Mysql;

import java.sql.*;

public class c5 {
    public static void main(String[] args){
        Connection conn=C4.getConnection();
//        System.out.println(conn);
        try {
            Connection con = LianJie_Mysql.LJ_Mysql(); // 声明Connection对象
            PreparedStatement sql = con.prepareStatement("select * from user"); // 声明PreparedStatement对象
            ResultSet res = sql.executeQuery(); // 声明ResultSet对象
            ResultSetMetaData data=res.getMetaData();
            int columnCount=data.getColumnCount();  //获取到表里面列的数量  res.getMetaData().getColumnCount()也可以，省略一步
            while (res.next()) {
                for (int i = 1; i <=columnCount ; i++) {   //定义一个数字，让它在 1到列的数量之间递增，可以输出每一列的所有参数
                   if (i!=columnCount){
                       System.out.print(res.getString(i) + "\t" ); //当没有走完一整n列（一共有列，当数字不等于n的时候，不要换行输出）
                   }
                   else {
                       System.out.println(res.getString(i) + "\t" ); //当走完一列时，换行输出
                   }
                }  //其实直接在for循环后面加一个换行输出就可以了，跑完所有列其实已经关闭了for循环，然后while循环再次跑，不需要if else。。。。。
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
