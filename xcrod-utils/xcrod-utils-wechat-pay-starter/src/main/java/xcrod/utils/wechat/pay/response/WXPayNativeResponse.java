package xcrod.utils.wechat.pay.response;

import xcrod.utils.wechat.pay.util.WXHttpConnectUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-12 10:44
 */
public class WXPayNativeResponse extends AbstractWXPayResponse {

    public WXPayNativeResponse(WXHttpConnectUtil.Entry responseEntry) throws Exception {
        super(responseEntry);
    }

    @Override
    public Map<String, String> getBody() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("prepay_id", super.body.get("prepay_id"));
        result.put("code_url", super.body.get("code_url"));
        return result;
    }

}
