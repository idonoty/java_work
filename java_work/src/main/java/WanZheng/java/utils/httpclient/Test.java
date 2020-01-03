package WanZheng.java.utils.httpclient;

public class Test {
    public static void main(String[] args) {
        String result=HttpClientUtils.doPost(
                "http://192.168.1.192:19901",
                "/user/order/buyOrder.json?",
                "device=20" +
                        "&token=038092baf53d205b27b4ae0cde59af7f" +
                        "&limitBuyPrice=9.25" +
                        "&loseLine=97.0" +
                        "&startPrice=8.47&deposit=125.0" +
                        "&money=1000.0" +
                        "&winLine=1000.0" +
                        "&code=600398.SH",
                null);
        System.out.println(result);
        String result2=HttpClientUtils.doPost(
                "http://192.168.1.192:19901/",
                "user/account/cashApply.json?",
                "money=500&bizPassword=123456",
                null);
        System.out.println(result2);
    }

}
