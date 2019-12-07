package xcrod.utils.wechat.pay.request;


import xcrod.utils.wechat.pay.properties.AbstractWXPayProperties;
import xcrod.utils.wechat.pay.response.WXPayResponse;
import xcrod.utils.wechat.pay.response.WXPayWapResponse;
import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;


/**
 * @author 王超
 * @create 2019-10-12 10:38
 */
public class WXPayWapRequest extends AbstractWXPayRequest {

    public WXPayWapRequest(AbstractWXPayProperties properties) {
        super(properties);
    }

    @Override
    public WXPayResponse unifiedOrder() throws Exception {
        super.addParams("trade_type", "MWEB");
        return super.unifiedOrder();
    }

    @Override
    public WXPayResponse getWXPayResponse(WXHttpConnectUtil.Entry entry) throws Exception {
        return new WXPayWapResponse(entry);
    }

}
