package xcrod.utils.wechat.pay.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-11 14:59
 */
@Getter
@Setter
@ConfigurationProperties("xcrod.wechat.pay.wap")
public class WXPayWapProperties extends AbstractWXPayProperties {


}
