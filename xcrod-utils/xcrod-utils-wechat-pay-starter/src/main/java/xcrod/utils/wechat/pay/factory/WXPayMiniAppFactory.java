package xcrod.utils.wechat.pay.factory;

import xcrod.utils.wechat.pay.properties.WXPayMiniAppProperties;
import xcrod.utils.wechat.pay.request.WXPayMiniAppRequest;
import xcrod.utils.wechat.pay.request.WXPayRequest;

/**
 * 微信支付 - 微信小程序支付创建工厂
 *
 * @author 王超
 * @create 2019-10-11 15:14
 */
public class WXPayMiniAppFactory extends AbstractWXPayFactory {

    public WXPayMiniAppFactory(WXPayMiniAppProperties properties) {
        super();
        super.properties = properties;
    }

    @Override
    public WXPayRequest createRequest() {
        return new WXPayMiniAppRequest(super.properties);
    }


}
