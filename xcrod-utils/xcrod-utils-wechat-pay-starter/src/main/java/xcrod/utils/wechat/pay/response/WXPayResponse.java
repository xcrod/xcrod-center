package xcrod.utils.wechat.pay.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author 王超
 * @create 2019-10-12 10:38
 */
public interface WXPayResponse {

    /**
     * 获取支付类别结果数据
     *
     * @return
     */
    Map<String, String> getBody();

    /**
     * 获取支付返回结果参数
     *
     * @return
     */
    Map<String, String> getResponse();

    /**
     * 获取支付返回结果参数
     *
     * @return
     */
    ErrorMsg getErrorMsg();

    /**
     * 获取请求返回状态码
     *
     * @return
     */
    Integer getResponseCode();

    /**
     * 判断请求执行是否成功
     *
     * @return
     */
    boolean isSuccess();

    @Getter
    @Setter
    class ErrorMsg {
        private String errorCode;
        private String message;

        ErrorMsg(String errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }

        @Override
        public String toString() {
            return String.format("错误编码：%s\n错误信息：%s\n", this.errorCode, this.message);
        }
    }
}
