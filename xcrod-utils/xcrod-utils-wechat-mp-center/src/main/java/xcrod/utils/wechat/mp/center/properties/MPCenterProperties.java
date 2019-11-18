package xcrod.utils.wechat.mp.center.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import xcrod.utils.wechat.mp.center.constant.MPConstant;


/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-11-18 14:33
 */
@ConfigurationProperties("xcrod.mp")
public class MPCenterProperties {

    @Getter
    @Setter
    private MPConstant.Domain domain = MPConstant.Domain.DEMO_DOMAIN;
    @Getter
    private MPConstant.Domain disasterDomainUrl = MPConstant.Domain.DISASTER_DEMO_DOMAIN;


    @Getter
    @Setter
    private String appid;
    @Getter
    @Setter
    private String appSecret;

}
