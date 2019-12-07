package xcrod.utils.wechat.mp.center.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import xcrod.api.algorithmic.Sha1;
import xcrod.api.utils.HttpConnectUtil;
import xcrod.api.utils.XmlUtil;
import xcrod.utils.wechat.mp.center.api.AccessTokenProcessor;
import xcrod.utils.wechat.mp.center.properties.MPCenterProperties;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @author 王超
 * @create 2019-11-18 14:04
 */
@Slf4j
public class MPCenterFactory {

    private AccessTokenProcessor accessTokenProcessor;
    private MPCenterProperties mpCenterProperties;

    public MPCenterFactory(AccessTokenProcessor accessTokenProcessor, MPCenterProperties mpCenterProperties) {
        this.accessTokenProcessor = accessTokenProcessor;
        this.mpCenterProperties = mpCenterProperties;
    }

    private String accessToken;
    private Integer expiresIn;


    @PostConstruct
    private void init() throws Exception {
        log.info("开始获取accessToken");
        this.getAccessToken();
        log.info("获取accessToken 结束");
    }

    public Map<String, String> formatXmlToMap(String xmlStr) throws Exception {
        return XmlUtil.xmlToMap(xmlStr);
    }


    /**
     * 验证消息的确来自微信服务器
     *
     * @param token
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public String checkServerResponse(String token, String timestamp, String nonce, String signature) throws Exception {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            throw new Exception("参数为空");
        }
        if (Sha1.encode(nonce + timestamp + token).equals(signature)) {
            return signature;
        } else {
            throw new Exception("消息验证失败");
        }
    }


    private void getAccessToken() throws Exception {
        HttpConnectUtil.Entry entry = accessTokenProcessor.getAccessToken(mpCenterProperties.getAppid(), mpCenterProperties.getAppSecret());
        if (entry.getResponseCode() == 200) {
            JSONObject jo = JSON.parseObject(entry.getBody());
            this.accessToken = jo.getString("access_token");
            if (this.accessToken == null) {
                throw  new Exception(String.format("获取accessToken 失败：%s", entry.getBody()));
            }
            this.expiresIn = jo.getInteger("expires_in");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        getAccessToken();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, (expiresIn - 120) * 1000L);
        } else {
            throw new Exception(String.format("错误信息：%s", entry.toString()));
        }
    }

}
