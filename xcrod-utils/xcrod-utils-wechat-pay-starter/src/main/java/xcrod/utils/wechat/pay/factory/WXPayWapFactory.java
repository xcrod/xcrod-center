package xcrod.utils.wechat.pay.factory;

import xcrod.utils.wechat.pay.properties.WXPayWapProperties;
import xcrod.utils.wechat.pay.request.WXPayWapRequest;
import xcrod.utils.wechat.pay.request.WXPayRequest;

/**
 * 微信支付 - H5 支付创建工厂
 * @author 王超
 * @create 2019-10-11 15:14
 */
public class WXPayWapFactory extends AbstractWXPayFactory {

    public WXPayWapFactory(WXPayWapProperties properties) {
        super();
        super.properties = properties;
    }

    @Override
    public WXPayRequest createRequest() {
        return new WXPayWapRequest(super.properties);
    }


}
