package xcrod.utils.wechat.mp.center.constant;

/**
 * @author 王超
 * @create 2019-11-18 14:27
 */
public class MPConstant {
    public enum Domain{

        DEMO_DOMAIN("api.weixin.qq.com"),
        DISASTER_DEMO_DOMAIN("api2.weixin.qq.com"),
        SHANG_HAI_DOMAIN("sh.api.weixin.qq.com"),
        SHEN_ZHEN_DOMAIN("sz.api.weixin.qq.com"),
        XIANG_GANG_DOMAIN("hk.api.weixin.qq.com");

        String domainUrl;
        Domain(String domainUrl){
            this.domainUrl = domainUrl;
        }

        @Override
        public String toString() {
            return this.domainUrl;
        }
    }

    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

}
