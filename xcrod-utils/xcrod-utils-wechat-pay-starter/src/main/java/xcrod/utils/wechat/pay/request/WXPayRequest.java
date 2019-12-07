package xcrod.utils.wechat.pay.request;


import xcrod.utils.wechat.pay.response.WXPayResponse;
import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;

import java.util.Map;

/**
 * @author 王超
 * @create 2019-10-12 10:38
 */
public interface WXPayRequest {

    /**
     * 添加请求参数
     *
     * @param key
     * @param param
     * @return
     */
    WXPayRequest addParams(String key, String param);

    /**
     * 设置请求参数
     *
     * @param params
     * @return
     */
    WXPayRequest setParams(Map<String, String> params);

    /**
     * 通过key 获取param
     *
     * @param key
     * @return
     */
    String getParamByKey(String key);

    /**
     * 统一下单接口
     *
     * @return
     */
    WXPayResponse unifiedOrder() throws Exception;


    /**
     * 获取微信支付返回结果
     *
     * @param entry
     * @return
     * @throws Exception
     */
    WXPayResponse getWXPayResponse(WXHttpConnectUtil.Entry entry) throws Exception;

//    String todoSign(Map<String, String> requestParams) throws Exception;

//    boolean checkSign(Map<String, String> requestParams) throws Exception;

}
