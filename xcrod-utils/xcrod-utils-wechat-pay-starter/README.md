#微信支付SDK 

---
现集成`H5 支付`，`小程序支付`，`扫码支付`, `公众号支付`。

测试代码:
```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import WXPayConfig;
import WXPayAppFactory;
import WXPayMiniAppFactory;
import WXPayNativeFactory;
import WXPayWapFactory;
import WXPayRequest;
import WXPayResponse;
import WXHttpConnectUtil;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WXPayConfig.class
})
public class WechatPayTestApplication {

    @Autowired
    WXPayWapFactory weWxPayWapFactory;

    @Autowired
    WXPayNativeFactory wxPayNativeFactory;

    @Autowired
    WXPayAppFactory wxPayAppFactory;

    @Autowired
    WXPayMiniAppFactory wxPayMiniAppFactory;

    @Test
    public void createMWEBFactory() throws Exception {
        WXPayRequest request = weWxPayWapFactory.createRequest();
        WXPayResponse response;
        response = request.addParams("body", "测试支付")
                .addParams("out_trade_no", "2301000033726")
                .addParams("total_fee", "888")
                .addParams("spbill_create_ip", "10.101.100.1")
                .addParams("scene_info", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"https://pay.qq.com\",\"wap_name\": \"腾讯充值\"}}")
                .unifiedOrder();
        if (response.isSuccess()) {
            System.out.println(response.getBody());
        } else {
            System.out.println(response.getErrorMsg());
        }


        request = wxPayNativeFactory.createRequest();
        response = request.addParams("body", "测试支付")
                .addParams("out_trade_no", "2301000033726")
                .addParams("total_fee", "888")
                .addParams("product_id", "268888888")
                .addParams("spbill_create_ip", "10.101.100.1")
                .unifiedOrder();
        if (response.isSuccess()) {
            System.out.println(response.getBody());
        } else {
            System.out.println(response.getErrorMsg());
        }

        request = wxPayAppFactory.createRequest();
        response = request.addParams("body", "测试支付")
                .addParams("out_trade_no", "2301000033726")
                .addParams("total_fee", "888")
                .addParams("spbill_create_ip", "10.101.100.1")
                .unifiedOrder();
        if (response.isSuccess()) {
            System.out.println(response.getBody());
        } else {
            System.out.println(response.getErrorMsg());
        }

        request = wxPayMiniAppFactory.createRequest();
        response = request.addParams("body", "测试支付")
                .addParams("out_trade_no", "2301000033726")
                .addParams("total_fee", "888")
                .addParams("spbill_create_ip", "10.101.100.1")
                .unifiedOrder();
        if (response.isSuccess()) {
            System.out.println(response.getBody());
        } else {
            System.out.println(response.getErrorMsg());
        }

    }

}

``` 

