package com.ruSkidex.RestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class GetRegisterEmail {
    HttpURLConnection connection;
    public String getRegisterEmail() throws ProtocolException {
        String answer = "";

        try {
            URL url = new URL("https://t.skidex.ru/qa/generate-test-email");
            connection = (HttpURLConnection) url.openConnection();

            property();

            connection.connect();

            int code = connection.getResponseCode();

            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(),"UTF-8"));
                answer = "";
                String line = null;

                while ((line = reader.readLine()) != null) {
                    answer += line;
                }
                reader.close();

            }
            connection.disconnect();
        }catch (IOException e){

        }
        return  answer;
    }
    private void property() throws ProtocolException {
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Cookie","PHPSESSID:6avm7htb95ldu9cqugjpuj6v5v" );
    }
}
