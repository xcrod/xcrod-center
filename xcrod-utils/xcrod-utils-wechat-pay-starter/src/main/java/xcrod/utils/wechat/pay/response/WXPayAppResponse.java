package xcrod.utils.wechat.pay.response;

import xcrod.utils.wechat.pay.properties.AbstractWXPayProperties;
import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;
import xcrod.utils.wechat.pay.util.WXPayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王超
 * @create 2019-10-12 10:44
 */
public class WXPayAppResponse extends AbstractWXPayResponse {

    private AbstractWXPayProperties properties;

    public WXPayAppResponse(WXHttpConnectUtil.Entry responseEntry, AbstractWXPayProperties properties) throws Exception {
        super(responseEntry);
        this.properties = properties;
    }

    @Override
    public Map<String, String> getBody() {
        Long timeStamp = System.currentTimeMillis() / 1000;
        Map<String, String> params = new HashMap<>();
        params.put("appid", properties.getAppId());
        params.put("partnerid", properties.getMchId());
        params.put("prepayid", super.body.get("prepay_id"));
        params.put("timestamp", String.valueOf(timeStamp));
        params.put("noncestr", WXPayUtil.generateNonceStr(6));
        params.put("package", "Sign=WXPay");
        try {
            params.put("sign", WXPayUtil.generateSignature(params, properties.getMchKey(), properties.getSignType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }


}
