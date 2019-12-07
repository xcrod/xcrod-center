package xcrod.utils.wechat.pay.constant;

/**
 * @author 王超
 * @create 2019-10-12 10:26
 */
public class WXPayConstants {

    public enum SignType {
        MD5("MD5"), HMACSHA256("HMAC-SHA256");

        private String title;
        SignType(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return this.title;
        }

    }

    public static final String FAIL     = "FAIL";
    public static final String SUCCESS  = "SUCCESS";

    public static final String RETURN_CODE  = "return_code";
    public static final String RESULT_CODE  = "result_code";

    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";

    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";

    /** 统一下单API */
    public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    

}
