package com.fx.piaodingding.cases;

import com.fx.piaodingding.config.TestConfig;
import com.fx.piaodingding.model.InterfaceName;
import com.fx.piaodingding.utils.ConfigFile;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.BeforeTest;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作")
    public void beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);

        TestConfig.closeableHttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();

    }
}
