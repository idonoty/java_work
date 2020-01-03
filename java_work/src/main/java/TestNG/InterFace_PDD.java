package TestNG;

import WanZheng.java.utils.httpclient.HttpClientUtils;

public class InterFace_PDD {
    public static String TestUrl="http://server.pdd.test";
    public static String result;
    public static String UserToken="5ea0d34476579d518dff90cbd8b92e16"; //用户id：117

//    public static void login(){
//        result=HttpClientUtils.doGet(TestUrl,
//                "/appleLogin.json?",
//                "token=14992c557934d9b3679d0a705cc5e7ae&code=061spcAW08Rma12jg4zW0X36AW0spcAo",
//                null);
//        System.out.println("登陆："+result);
//    }  //微信自己接口，code每次都会变

    public static void getAllPassenger(){
        result=HttpClientUtils.doGet(TestUrl,
                "/user/passenger/getAllPassenger.json?",
                "token="+UserToken,
                null);
        System.out.println("获取用户联系人列表："+result);
    }

    public static void getPassengerById(){
        result=HttpClientUtils.doGet(TestUrl,
                "/user/passenger/getPassengerById.json?",
                "token="+UserToken+"&id=167",
                null);
        System.out.println("获取单个联系人："+result);
    }
    public static void updatePassenger(){
        result=HttpClientUtils.doPostJson(TestUrl,"/user/passenger/updatePassenger.json?",
                "{\"birthday\": \"2005-04-06\",\n" +
                        "  \"code\": \"86\",\n" +
                        "  \"credentials\": [\n" +
                        "    {\n" +
                        "      \"certificateExpireDate\": \"2028-7-25\",\n" +
                        "      \"certificateNo\": \"320402200504065824\",\n" +
                        "      \"certificateType\": 1\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"englishLastName\": \"SHEN\",\n" +
                        "  \"englishName\": \"XINYU\",\n" +
                        "  \"gender\": 0,\n" +
                        "  \"id\": 167,\n" +
                        "  \"mobile\": \"13510285646\",\n" +
                        "  \"name\": \"沈心语\",\n" +
                        "  \"nation\": \"CN\",\n" +
                        "  \"token\": \""+UserToken+"\",\n" +
                        "  \"userType\": 0\n" +
                        "}",null);
        System.out.println("修改联系人信息："+result);
    }
}