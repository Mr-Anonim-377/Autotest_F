package com.ruSkidex.RestMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class HttpLocationCheck {
    HttpURLConnection connection;
    public  boolean referenceChecking(String location) throws ProtocolException {
        boolean isLocationOk = false;
        try {



            URL url = new URL(location);
            connection = (HttpURLConnection) url.openConnection();

            property();

            connection.connect();

            int code = connection.getResponseCode();

            if (code == HttpURLConnection.HTTP_OK) {
                isLocationOk = true;
            }
            connection.disconnect();
        }catch (IOException e){

        }
        return  isLocationOk;
    }
    private void property() throws ProtocolException {
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Cookie","PHPSESSID:6avm7htb95ldu9cqugjpuj6v5v" );
    }
}
