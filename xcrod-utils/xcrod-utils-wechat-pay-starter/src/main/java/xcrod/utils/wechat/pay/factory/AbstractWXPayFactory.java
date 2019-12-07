package xcrod.utils.wechat.pay.factory;

import xcrod.utils.wechat.pay.constant.WXPayConstants;
import xcrod.utils.wechat.pay.properties.AbstractWXPayProperties;
import xcrod.utils.wechat.pay.util.WXPayUtil;
import lombok.Getter;

import java.util.Map;

/**
 * @author 王超
 * @create 2019-11-03 11:49
 */
public abstract class AbstractWXPayFactory implements WXPayFactory {

    @Getter
    protected AbstractWXPayProperties properties;


    @Override
    public boolean checkSign(String xmlStr) throws Exception {
        return checkSign(WXPayUtil.xmlToMap(xmlStr));
    }

    public boolean checkSign(Map<String, String> requestParams) throws Exception {
        String signType = requestParams.get("sign_type");
        return (signType != null && signType.equals(WXPayConstants.HMACSHA256))
                ? WXPayUtil.isSignatureValid(requestParams, properties.getMchKey(), WXPayConstants.SignType.HMACSHA256)
                : WXPayUtil.isSignatureValid(requestParams, properties.getMchKey());
    }

}
