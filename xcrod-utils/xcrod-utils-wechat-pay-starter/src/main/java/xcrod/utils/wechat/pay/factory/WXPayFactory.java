package xcrod.utils.wechat.pay.factory;

import xcrod.utils.wechat.pay.request.WXPayRequest;

import java.util.Map;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-12 10:42
 */
public interface WXPayFactory {

    /**
     * 创建微信支付请求体
     *
     * @return
     */
    WXPayRequest createRequest();

    /**
     * 检查支付回调请求签名是否正确
     *
     * @return
     */
    boolean checkSign(String xmlStr) throws Exception;

    /**
     * 检查支付回调请求签名是否正确
     *
     * @return
     */
    boolean checkSign(Map<String, String> params) throws Exception;


}
