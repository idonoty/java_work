package HttpClient.JiChu;

public class HttpTest {
    public static void main(String[] args) {
        String suite =The_HttpClient.doGet("http://localhost:8088/demo");
        System.out.println(suite);

//        Map data = new HashMap();
//        data.put("username","yyc1");
//        data.put("password","yyc111");
//        data.put("device","30");
//        String ru=The_HttpClient.doPost("http://api.codai.vip/login.json?",data);
//        System.out.println(ru);
    }
}
