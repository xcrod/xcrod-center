package xcrod.utils.wechat.mp.center.api;


import xcrod.api.utils.HttpConnectUtil;

import java.io.IOException;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-11-18 14:41
 */
public interface AccessTokenProcessor {

    HttpConnectUtil.Entry getAccessToken(String appid, String appSecret) throws IOException;


}
