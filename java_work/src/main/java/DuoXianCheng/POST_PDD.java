package DuoXianCheng;

import WanZheng.java.utils.httpclient.HttpClientUtils;

public class POST_PDD {
    public static void aa() {
            String re=HttpClientUtils.doPostJson("http://192.168.1.53:3000/","ctrip/flightSearch?","[{\"dtime\":\"2019-06-17\",\"accode\":\"HGH\",\"dccode\":\"TAO\",\"foreign\":false},{\"dtime\":\"2019-06-17\",\"accode\":\"HGH\",\"dccode\":\"CSX\",\"foreign\":false}] ","content-type=application/json;accept-encoding=gzip");
            System.out.println(re);
            System.out.println(HttpClientUtils.allTime);



    }
    public static void city()  {
        //长沙CSX,广州CAN,上海SHA,北京BJS，深圳SZX,成都CTU,武汉WUH,西安SIA,杭州HGH,重庆CKG，青岛TAO,南京NKG,厦门XMN
        String[] str1 = { "CSX", "CAN","SHA","BJS","SZX","CTU","WUH","SIA","HGH","CKG","TAO", "NKG","XMN"  };
        String[] str2 = { "CSX", "CAN","SHA","BJS","SZX","CTU","WUH","SIA","HGH","CKG","TAO", "NKG","XMN"  };
        for (int i = 17; i <30 ; i++) {
            int random = (int) ( Math.random () * 13 );  //Math.random ()是取0.0和1.0的数
            int random2 = (int) ( Math.random () * 13 );
            if (str1[random].equals(str2[random2])){
                System.out.println("相等了");
            }else {
                System.out.println(str1[random]+" "+str2[random2]);
                String re=HttpClientUtils.doPostJson("http://192.168.1.53:3000/","ctrip/flightSearch?","[{\"dtime\":\"2019-06-"+i+"\",\"accode\":\""+str1[random]+"\",\"dccode\":\""+str2[random2]+"\",\"foreign\":false}] ","content-type=application/json;accept-encoding=gzip");
                System.out.println(re);
                System.out.println(i);
                System.out.println(HttpClientUtils.allTime);
            }
        }

    }
    public static void main(String[] args) {
        try {
            city();
        }catch (ArrayIndexOutOfBoundsException e){  //索引为负或大于等于数组大小时提示非法索引，上面数组13个字符不能用大于13的索引 (Math.random () * 14);
            System.out.println("索引有误");
        }
        //aa();
    }
}



