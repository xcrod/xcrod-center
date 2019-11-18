package xcrod.utils.wechat.pay.util;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-12 15:15
 */
public class WXHttpConnectUtil {

    public static Entry executePostRequest(final String address, final String data) throws IOException {

        HttpURLConnection connection;
        BufferedReader bufferedReader;

        StringBuilder stringBuilder = new StringBuilder();

        URL url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("content-type", "application/xml;charset=utf-8");
        connection.setRequestProperty("Accept", "*/*");

        if (data != null) {
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
        }


        InputStream inputStream;
        Integer responseCode = connection.getResponseCode();
        inputStream = (responseCode >= 400)
                ? connection.getErrorStream()
                : connection.getInputStream();

        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inputStream.close();
        connection.disconnect();


        return new Entry(stringBuilder.toString(), responseCode);
    }

    @Getter
    public static class Entry {
        private String body;
        private Integer responseCode;

        Entry(String body, Integer responseCode) {
            this.body = body;
            this.responseCode = responseCode;
        }
    }


}
