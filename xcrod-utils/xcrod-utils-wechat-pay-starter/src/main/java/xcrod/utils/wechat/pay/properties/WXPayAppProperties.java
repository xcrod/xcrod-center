package xcrod.utils.wechat.pay.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author 王超
 * @create 2019-10-11 14:59
 */
@Getter
@Setter
@ConfigurationProperties("xcrod.wechat.pay.app")
public class WXPayAppProperties extends AbstractWXPayProperties {


}
