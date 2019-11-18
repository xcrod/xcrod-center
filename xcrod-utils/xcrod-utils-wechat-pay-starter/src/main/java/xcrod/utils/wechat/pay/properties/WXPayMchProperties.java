package xcrod.utils.wechat.pay.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-15 10:57
 */
@Getter
@Setter
@ConfigurationProperties("xcrod.wechat.pay")
public class WXPayMchProperties {

    private String mchId;
    private String mchKey;
    private String notifyUrl;

}
