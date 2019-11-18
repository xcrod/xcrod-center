package xcrod.utils.wechat.pay.factory;

import xcrod.utils.wechat.pay.properties.WXPayNativeProperties;
import xcrod.utils.wechat.pay.request.AbstractWXPayRequest;
import xcrod.utils.wechat.pay.request.WXPayNativeRequest;

/**
 * 微信支付 - 扫码支付方式创建工厂
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-11 15:14
 */
public class WXPayNativeFactory extends AbstractWXPayFactory {

    public WXPayNativeFactory(WXPayNativeProperties properties) {
        super();
        super.properties = properties;
    }

    @Override
    public AbstractWXPayRequest createRequest() {
        return new WXPayNativeRequest(super.properties);
    }


}
