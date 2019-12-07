package xcrod.utils.wechat.mp.center.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xcrod.utils.wechat.mp.center.api.AccessTokenProcessor;
import xcrod.utils.wechat.mp.center.api.AccessTokenProcessorImpl;
import xcrod.utils.wechat.mp.center.factory.MPCenterFactory;
import xcrod.utils.wechat.mp.center.properties.MPCenterProperties;

/**
 * @author 王超
 * @create 2019-11-18 14:20
 */
@Configuration
@EnableConfigurationProperties({
        MPCenterProperties.class
})
public class MPCenterAutoConfiguration {

    @Bean
    public MPCenterFactory mpCenterFactory(AccessTokenProcessor accessTokenProcessor, MPCenterProperties mpCenterProperties) {
        return new MPCenterFactory(accessTokenProcessor, mpCenterProperties);
    }

    @Bean
    @ConditionalOnMissingBean(AccessTokenProcessor.class)
    public AccessTokenProcessor accessTokenProcessor() {
        return new AccessTokenProcessorImpl();
    }


}
