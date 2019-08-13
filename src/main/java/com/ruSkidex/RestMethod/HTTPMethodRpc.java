package com.ruSkidex.RestMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class HTTPMethodRpc {

    public String getRpcMethodAnswer(String outJson) {
        HttpURLConnection connection;

        String answer = "";
        try {
            URL url = new URL("https://t.skidex.ru/api/rpc/");
            connection = (HttpURLConnection) url.openConnection();
            byte[] out = outJson.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            connection.setFixedLengthStreamingMode(length);

            property(connection);

            connection.connect();
            try (OutputStream outStream = connection.getOutputStream()) {

                outStream.write(out);
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(connection.getInputStream(), "UTF-8"));

                answer = "";
                String line = null;

                InputStream in = connection.getInputStream();

                GZIPInputStream gIn = new GZIPInputStream(in);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(gIn, "UTF-8"));

//

                while ((line = reader.readLine()) != null) {
                    answer += line;
                }
                reader.close();

            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private void property(HttpURLConnection connection) throws ProtocolException {
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
        connection.setRequestProperty("Cookie", "PHPSESSID:6avm7htb95ldu9cqugjpuj6v5v");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    }
}
