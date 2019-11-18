package xcrod.api.utils;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author 王超
 * @company 上海龟元数据科技有限公司
 * @create 2019-10-12 15:15
 */
public class HttpConnectUtil {



    public static Entry get(final String address) throws IOException {
        return get(address, null);
    }
    public static Entry get(final String address, final Map<String, String> headers) throws IOException {

        HttpURLConnection connection;


        URL url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "*/*");
        if (headers != null)
            headers.forEach(connection::setRequestProperty);



        return formatResponseMessage(connection);
    }

    public static Entry post(final String address, final String data) throws IOException {
        return post(address, data, null);
    }
    public static Entry post(final String address, final String data, final Map<String, String> headers) throws IOException {

        HttpURLConnection connection;

        URL url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "*/*");
        if (headers != null)
            headers.forEach(connection::setRequestProperty);


        if (data != null) {
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
        }


        return formatResponseMessage(connection);
    }


    private static Entry formatResponseMessage(HttpURLConnection connection) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
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
