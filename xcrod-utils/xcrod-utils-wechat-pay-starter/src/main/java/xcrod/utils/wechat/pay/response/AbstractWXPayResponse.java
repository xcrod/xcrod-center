package xcrod.utils.wechat.pay.response;

import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;
import xcrod.utils.wechat.pay.util.WXPayUtil;

import java.util.Map;

import static xcrod.utils.wechat.pay.constant.WXPayConstants.*;

/**
 * @author 王超
 * @create 2019-10-12 10:38
 */
public abstract class AbstractWXPayResponse implements WXPayResponse {

    final Map<String, String> body;
    private final Integer responseCode;
    private final boolean success;

    AbstractWXPayResponse(WXHttpConnectUtil.Entry responseEntry) throws Exception {
        this.body = WXPayUtil.xmlToMap(responseEntry.getBody());
        this.responseCode = responseEntry.getResponseCode();

        this.success = (SUCCESS.equals(this.body.get(RETURN_CODE)) && SUCCESS.equals(this.body.get(RESULT_CODE)));
    }

    @Override
    public abstract Map<String, String> getBody();

    @Override
    public Map<String, String> getResponse() {
        return body;
    }

    @Override
    public Integer getResponseCode() {
        return this.responseCode;
    }

    @Override
    public boolean isSuccess() {
        return this.success;
    }

    @Override
    public ErrorMsg getErrorMsg() {
        return new ErrorMsg(this.body.get("err_code"), this.body.get("err_code_des"));
    }
}
