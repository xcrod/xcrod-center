package xcrod.utils.wechat.pay.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 王超
 * @create 2019-10-11 14:59
 */
@Getter
@Setter
@ConfigurationProperties("xcrod.wechat.pay.mini-app")
public class WXPayMiniAppProperties extends AbstractWXPayProperties {


}
