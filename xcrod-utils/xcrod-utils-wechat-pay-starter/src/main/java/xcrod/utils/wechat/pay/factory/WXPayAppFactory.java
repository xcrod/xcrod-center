package xcrod.utils.wechat.pay.factory;

import xcrod.utils.wechat.pay.properties.WXPayAppProperties;
import xcrod.utils.wechat.pay.request.WXPayAppRequest;
import xcrod.utils.wechat.pay.request.WXPayRequest;

/**
 * 微信支付 - APP 支付创建工厂
 * @author 王超
 * @create 2019-10-11 15:14
 */
public class WXPayAppFactory extends AbstractWXPayFactory {

    public WXPayAppFactory(WXPayAppProperties properties) {
        super();
        super.properties = properties;
    }

    @Override
    public WXPayRequest createRequest() {
        return new WXPayAppRequest(super.properties);
    }


}
