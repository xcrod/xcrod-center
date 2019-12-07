package xcrod.utils.wechat.pay.response;

import xcrod.utils.wechat.pay.constant.WXPayConstants;
import xcrod.utils.wechat.pay.exception.WXPayException;
import xcrod.utils.wechat.pay.properties.AbstractWXPayProperties;
import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;
import xcrod.utils.wechat.pay.util.WXPayUtil;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static xcrod.utils.wechat.pay.constant.WXPayConstants.HMACSHA256;

/**
 * @author 王超
 * @create 2019-10-12 10:44
 */
public class WXPayMiniAppResponse extends AbstractWXPayResponse {

    private AbstractWXPayProperties properties;

    public WXPayMiniAppResponse(WXHttpConnectUtil.Entry responseEntry, AbstractWXPayProperties properties) throws Exception {
        super(responseEntry);
        this.properties = properties;
    }

    @Override
    public Map<String, String> getBody() {
        Long timeStamp = System.currentTimeMillis() / 1000;
        Map<String, String> params = new HashMap<>();
        params.put("appId", properties.getAppId());
        params.put("timeStamp", String.valueOf(timeStamp));
        params.put("nonceStr", WXPayUtil.generateNonceStr(6));
        params.put("package", super.body.get("prepay_id"));
        if (this.properties.getSignType().equals(WXPayConstants.SignType.HMACSHA256)){
            params.put("signType", HMACSHA256);
        }
        try {
            params.put("sign", WXPayUtil.generateSignature(params, properties.getMchKey(), properties.getSignType()));
        } catch (InvalidKeyException | NoSuchAlgorithmException | WXPayException e) {
            e.printStackTrace();
        }
        return params;

//        Map<String, String> result = new LinkedHashMap<>();
////        result.put("mweb_url", super.body.get("mweb_url"));
////        result.put("prepay_id", super.body.get("prepay_id"));
//        return result;
    }

}
