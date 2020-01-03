package DuoXianCheng;

import WanZheng.java.utils.httpclient.HttpClientUtils;

import java.util.HashMap;

public class PDD_addJianKong {
    public static void main(String[] args) {

        //长沙CSX,广州CAN,上海SHA,北京BJS，深圳SZX,成都CTU,武汉WUH,西安SIA,杭州HGH,重庆CKG，青岛TAO,南京NKG,厦门XMN,大庆DQA,
//        HashMap<String,String> map =new HashMap();
//        map.put("长沙","CSX");map.put("广州","CAN");map.put("上海","SHA");map.put("北京","BJS");map.put("深圳","SZX");map.put("成都","CTU");
//        map.put("武汉","WUH");map.put("西安","SIA");map.put("杭州","HGH");map.put("重庆","CKG");map.put("青岛","TAO");map.put("南京","NKG");
//        map.put("厦门","XMN");map.put("大庆","DQA");map.put("郑州","CGO");
//        map.forEach((key, value) -> AA(key, value));
        //addPAYJianKong();
        endJianKong();
        //addfreeJianKong();
        //addfreeJichang();
    }

    public static void addfreeJichang() {
        String[] str1 = { "BJS",         "CGO",     "SHA",    "BJS",      "ZYI",    "SHA",      "ZYI",     "CGO",    "WUH",     "BJS",   "WUH"};
        String[] str2 = { "北京密云穆嘉裕","郑州上街", "上海浦东","北京首都", "遵义茅台", "上海虹桥", "遵义新舟", "郑州新郑","武汉天河", "北京大兴","武汉汉南"};
        String[] str3 = {"MY2",          "HSJ",     "PVG",   "PEK",       "WMT",     "SHA",    "ZYI",       "CGO",   "WUH",    "PKX",       "HN3"};
        for (int i = 0; i < str1.length-1; i++) {
            //15505067922012173a18443a23c8aff3  572 我为何帅  联系人ID 179，7，136
            //aed77ce8c4a38cf198d4cce98a71f05b  118 文人      联系人ID 136
            String C = "token=aed77ce8c4a38cf198d4cce98a71f05b" +
                    "&foreign=0" +
                    "&startDate=2019-12-12" +
                    "&endDate=2019-12-12" +
                    "&departureCityCode=" + str1[i] +
                    "&departureCityName=" + str2[i] +
                    "&departureAirportCode="+str3[i] +
                    "&arrivalCityCode=" + str1[i + 1] +
                    "&arrivalCityName=" + str2[i + 1] +
                    "&arrivalAirportCode="+ str3[i+ 1] +
                    "&budgetPrice=1" +
                    "&cabin=A" +
                    "&travelPreference=0" +
                    "&hasBaby=0" +
                    "&hasChild=0" +
                    "&direct=0" +
                    "&travelPeople=1" +
                    "&flyTime=1,2,3,4" +
                    "&freeFlyTime=6-12,12-18,18-24,0-6" +
                    "&notice=2";
            String re = HttpClientUtils.doPost("https://piaotest.bangdingding.cn", "/flight/monitor/addFlightMonitor.json?",
                    C, "Content-Type=application/x-www-form-urlencoded");
            System.out.println(re);
            System.out.println(i);
            System.out.println(HttpClientUtils.allTime);
        }}

    public static void addfreeJianKong() {
        String[] str1 = {"CSX", "CAN", "SHA", "BJS", "SZX", "CTU", "WUH", "SIA", "HGH", "CKG", "TAO", "NKG", "XMN", "DQA", "CGO","URC"};
        String[] str2 = {"长沙", "广州", "上海", "北京", "深圳", "成都", "武汉", "西安", "杭州", "重庆", "青岛", "南京", "厦门", "大庆", "郑州","乌鲁木齐"};
        for (int i = 0; i < 3; i++) {
            //15505067922012173a18443a23c8aff3  572 我为何帅  联系人ID 179，7，136
            //1a41ebcae922195821ea8bb9d51be430  573 文人      联系人ID 175，176，178
            String C = "token=fc17b48f7547b4293c5c3e885672cc16" +
                    "&foreign=0" +
                    "&startDate=2019-12-12" +
                    "&endDate=2019-12-12" +
                    "&departureCityCode=" + str1[i] +
                    "&departureCityName=" + str2[i] +
                    "&arrivalCityCode=" + str1[i + 1] +
                    "&arrivalCityName=" + str2[i + 1] +
                    "&budgetPrice=1" +
                    "&cabin=A" +
                    "&travelPreference=0" +
                    "&hasBaby=0" +
                    "&hasChild=0" +
                    "&direct=0" +
                    "&travelPeople=1" +
                    "&flyTime=1,2,3,4" +
                    "&freeFlyTime=6-12,12-18,18-24,0-6" +
                    "&notice=2";
            String re = HttpClientUtils.doPost("https://piaotest.bangdingding.cn", "/flight/monitor/addFlightMonitor.json?",
                    C, "Content-Type=application/x-www-form-urlencoded");
            System.out.println(re);
            System.out.println(i);
            System.out.println(HttpClientUtils.allTime);
        }}

    public static void addPAYJianKong() {
        String[] str1 = {"CSX", "CAN", "SHA", "BJS", "SZX", "CTU", "WUH", "SIA", "HGH", "CKG", "TAO", "NKG", "XMN", "DQA", "CGO","URC"};
        String[] str2 = {"长沙", "广州", "上海", "北京", "深圳", "成都", "武汉", "西安", "杭州", "重庆", "青岛", "南京", "厦门", "大庆", "郑州","乌鲁木齐"};
        for (int i = 0; i < 3; i++) {
            //15505067922012173a18443a23c8aff3  572 我为何帅  联系人ID 179，7，136
            //1a41ebcae922195821ea8bb9d51be430  573 文人      联系人ID 175，176，178
            String C = "token=fc17b48f7547b4293c5c3e885672cc16" +
                    "&foreign=0" +
                    "&startDate=2019-12-12" +
                    "&endDate=2019-12-12" +
                    "&departureCityCode=" + str1[i] +
                    "&departureCityName=" + str2[i] +
                    "&arrivalCityCode=" + str1[i + 1] +
                    "&arrivalCityName=" + str2[i + 1] +
                    "&budgetPrice=1" +
                    "&cabin=A" +
                    "&travelPreference=0" +
                    "&hasBaby=0" +
                    "&hasChild=0" +
                    "&direct=0" +
                    "&travelPeople=1" +
                    "&flyTime=1,2,3,4" +
                    "&freeFlyTime=6-12,12-18,18-24,0-6" +
                    "&notice=2"
                    + "&bail=2&monitorDays=1&monitorMoney=2&passengerIds=136";
            //  /pay/flight/monitor/addPayMonitor.json? 付费
            //  /flight/monitor/addFlightMonitor.json?  免费
            String re = HttpClientUtils.doPost("https://piaotest.bangdingding.cn", "/pay/flight/monitor/addPayMonitor.json?",
                    C, "Content-Type=application/x-www-form-urlencoded");
            System.out.println(re);
            System.out.println(i);
            System.out.println(HttpClientUtils.allTime);
        }
    }

    public static void endJianKong() {
        for (int i = 0; i <=0 ; i++) {
            String re = HttpClientUtils.doPost("https://piaotest.bangdingding.cn",
                    "/flight/monitor/endMonitor.json?",
                    "token=f279421b560c9fa8f6c14f45b5c87216&id="+1073, "Content-Type=application/x-www-form-urlencoded");
            System.out.println(re);
        }

    }


}
