package xcrod.utils.wechat.pay.properties;

import xcrod.utils.wechat.pay.constant.WXPayConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author 王超
 * @create 2019-10-11 14:31
 */
@Setter
@Getter
public abstract class AbstractWXPayProperties {

    private boolean open = false;

    @NotNull
    private String appId;
    @NotNull
    private String appSecret;

    private String mchId;
    private String mchKey;
    private String notifyUrl;

    @NotNull
    private WXPayConstants.SignType signType = WXPayConstants.SignType.HMACSHA256;

}
