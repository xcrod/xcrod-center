package xcrod.utils.wechat.pay.request;


import xcrod.utils.wechat.pay.properties.AbstractWXPayProperties;
import xcrod.utils.wechat.pay.response.WXPayAppResponse;
import xcrod.utils.wechat.pay.response.WXPayResponse;
import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;


/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-12 10:38
 */
public class WXPayAppRequest extends AbstractWXPayRequest {

    public WXPayAppRequest(AbstractWXPayProperties properties) {
        super(properties);
    }

    @Override
    public WXPayResponse unifiedOrder() throws Exception {
        super.addParams("trade_type", "APP");
        return super.unifiedOrder();
    }

    @Override
    public WXPayResponse getWXPayResponse(WXHttpConnectUtil.Entry entry) throws Exception {
        return new WXPayAppResponse(entry, super.properties);
    }

}
