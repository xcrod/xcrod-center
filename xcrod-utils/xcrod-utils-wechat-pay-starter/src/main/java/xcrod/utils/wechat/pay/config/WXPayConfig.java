package xcrod.utils.wechat.pay.config;

import xcrod.utils.wechat.pay.factory.WXPayAppFactory;
import xcrod.utils.wechat.pay.factory.WXPayMiniAppFactory;
import xcrod.utils.wechat.pay.factory.WXPayWapFactory;
import xcrod.utils.wechat.pay.factory.WXPayNativeFactory;
import xcrod.utils.wechat.pay.properties.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-11 14:19
 */
@Configuration
@EnableConfigurationProperties({
        WXPayMchProperties.class,
        WXPayWapProperties.class,
        WXPayNativeProperties.class,
        WXPayMiniAppProperties.class,
        WXPayAppProperties.class
})
public class WXPayConfig {

    @Autowired
    WXPayMchProperties wxPayMchProperties;

    @Bean
    @ConditionalOnProperty(prefix = "xcrod.wechat.pay.wap", name = "open", havingValue = "true")
    public WXPayWapFactory wechatPayWapFactory(@Validated WXPayWapProperties properties) {
        this.formatProperties(properties);
        return new WXPayWapFactory(properties);
    }

    @Bean
    @ConditionalOnProperty(prefix = "xcrod.wechat.pay.native", name = "open", havingValue = "true")
    public WXPayNativeFactory wechatPayNativeFactory(@Validated WXPayNativeProperties properties) {
        this.formatProperties(properties);
        return new WXPayNativeFactory(properties);
    }

    @Bean
    @ConditionalOnProperty(prefix = "xcrod.wechat.pay.app", name = "open", havingValue = "true")
    public WXPayAppFactory wechatPayAppFactory(@Validated WXPayAppProperties properties) {
        this.formatProperties(properties);
        return new WXPayAppFactory(properties);
    }

    @Bean
    @ConditionalOnProperty(prefix = "xcrod.wechat.pay.mini-app", name = "open", havingValue = "true")
    public WXPayMiniAppFactory wechatPayMiniAppFactory(@Validated WXPayMiniAppProperties properties) {
        this.formatProperties(properties);
        return new WXPayMiniAppFactory(properties);
    }

    private void formatProperties(AbstractWXPayProperties properties){
        if(properties.getMchId() == null){
            properties.setMchId(wxPayMchProperties.getMchId());
            properties.setMchKey(wxPayMchProperties.getMchKey());
            properties.setNotifyUrl(wxPayMchProperties.getNotifyUrl());
        }
    }

}
