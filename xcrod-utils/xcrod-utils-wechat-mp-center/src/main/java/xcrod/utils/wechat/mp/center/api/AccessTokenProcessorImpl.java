package xcrod.utils.wechat.mp.center.api;

import xcrod.api.utils.HttpConnectUtil;
import xcrod.utils.wechat.mp.center.constant.MPConstant;

import java.io.IOException;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-11-18 15:28
 */
public class AccessTokenProcessorImpl implements AccessTokenProcessor {

    @Override
    public HttpConnectUtil.Entry getAccessToken(String appid, String appSecret) throws IOException {
        String url = MPConstant.ACCESS_TOKEN_URL.replace("APPID", appid)
                                                .replace("APPSECRET", appSecret);
        return HttpConnectUtil.get(url);
    }

}
