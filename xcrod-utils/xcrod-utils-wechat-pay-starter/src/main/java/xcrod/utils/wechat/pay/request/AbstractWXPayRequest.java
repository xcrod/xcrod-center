package xcrod.utils.wechat.pay.request;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import xcrod.utils.wechat.pay.constant.WXPayConstants;
import xcrod.utils.wechat.pay.exception.WXPayValidateException;
import xcrod.utils.wechat.pay.properties.AbstractWXPayProperties;
import xcrod.utils.wechat.pay.response.WXPayResponse;
import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;
import xcrod.utils.wechat.pay.util.WXPayUtil;

import java.util.Map;
import java.util.TreeMap;

import static xcrod.utils.wechat.pay.constant.WXPayConstants.FIELD_SIGN_TYPE;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-12 10:38
 */
@Slf4j
public abstract class AbstractWXPayRequest implements WXPayRequest {

    @Setter
    protected AbstractWXPayProperties properties;

    private Map<String, String> requestParams;

    AbstractWXPayRequest(AbstractWXPayProperties properties) {
        this.properties = properties;
    }

    /**
     * 添加请求参数
     *
     * @param key
     * @param param
     * @return
     */
    public AbstractWXPayRequest addParams(String key, String param) {
        if (this.requestParams == null)
            this.requestParams = new TreeMap<>();

        this.requestParams.put(key, param);
        return this;
    }

    /**
     * 设置请求参数
     *
     * @param params
     * @return
     */
    public AbstractWXPayRequest setParams(Map<String, String> params) {
        this.requestParams = params;
        return this;
    }

    public String getParamByKey(String key) {
        return this.requestParams.get(key);
    }

    /**
     * 统一下单接口
     *
     * @return
     */
    public WXPayResponse unifiedOrder() throws Exception {
        this.requestParams.put("appid", properties.getAppId());
        this.requestParams.put("mch_id", properties.getMchId());
        this.requestParams.put("nonce_str", WXPayUtil.generateNonceStr(6));
        this.requestParams.put("notify_url", properties.getNotifyUrl());
        if (properties.getSignType().equals(WXPayConstants.SignType.HMACSHA256)) {
            this.requestParams.put("sign_type", properties.getSignType().toString());
        }


        WXHttpConnectUtil.Entry responseEntry = WXHttpConnectUtil.executePostRequest(WXPayConstants.UNIFIEDORDER_URL, this.todoSign(this.requestParams));
        if (!this.checkSign(requestParams)) {
            throw new WXPayValidateException("统一下单接口返回值验签失败");
        }

        return getWXPayResponse(responseEntry);
    }


    /**
     * 进行签名处理
     *
     * @param requestParams
     * @return
     * @throws Exception
     */
    private String todoSign(Map<String, String> requestParams) throws Exception {
        String signType = requestParams.get(FIELD_SIGN_TYPE);
        return (signType != null && signType.equals(WXPayConstants.HMACSHA256))
                ? WXPayUtil.generateSignedXml(requestParams, properties.getMchKey(), WXPayConstants.SignType.HMACSHA256)
                : WXPayUtil.generateSignedXml(requestParams, properties.getMchKey());
    }

    private boolean checkSign(Map<String, String> requestParams) throws Exception {
        String signType = requestParams.get(FIELD_SIGN_TYPE);
        return (signType != null && signType.equals(WXPayConstants.HMACSHA256))
                ? WXPayUtil.isSignatureValid(requestParams, properties.getMchKey(), WXPayConstants.SignType.HMACSHA256)
                : WXPayUtil.isSignatureValid(requestParams, properties.getMchKey());
    }


}
