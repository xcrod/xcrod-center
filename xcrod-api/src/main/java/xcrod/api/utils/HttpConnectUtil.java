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
 * @create 2019-10-12 15:15
 */
public class HttpConnectUtil {


    public static Entry get(final String address) throws IOException {
        return get(address, null);
    }

    public static Entry get(final String address, final Map<String, String> headers) throws IOException {
        final String method = "GET";
        return formatResponseMessage(address, method, headers, null);
    }

    public static Entry post(final String address, final String data) throws IOException {
        return post(address, data, null);
    }

    public static Entry post(final String address, final String data, final Map<String, String> headers) throws IOException {
        final String method = "POST";
        return formatResponseMessage(address, method, headers, data);
    }


    private static Entry formatResponseMessage(final String address,
                                               final String method,
                                               final Map<String, String> headers,
                                               final String data) throws IOException {

        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Accept", "*/*");
            if (headers != null)
                headers.forEach(connection::setRequestProperty);

            if (data != null) {
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
            }

            StringBuilder stringBuilder = new StringBuilder();

            int responseCode = connection.getResponseCode();
            inputStream = (responseCode != 200)
                    ? connection.getErrorStream()
                    : connection.getInputStream();

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            return new Entry(stringBuilder.toString(), responseCode);
        } finally {
            if (bufferedReader != null) bufferedReader.close();
            if (inputStream != null) inputStream.close();
            if (connection != null) connection.disconnect();
        }
    }


    @Getter
    public static class Entry {
        private final String body;
        private final Integer responseCode;

        Entry(String body, Integer responseCode) {
            this.body = body;
            this.responseCode = responseCode;
        }
    }


}
