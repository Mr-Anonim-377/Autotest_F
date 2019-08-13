package com.ruSkidex.RestMethod;


import com.google.gson.Gson;
import com.ruSkidex.RestMethod.Gson.SearchOnMapGson;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class SearchOnMapShopAdress extends SearchOnMapGson {
    private HttpURLConnection connection;
    private String addresShop = null;



    public String searchOnMapShopAdress(String titleSearch) throws IOException {
        try {
            String answer = "";

            URL url = new URL("https://t.skidex.ru/api/rpc/");
            connection = (HttpURLConnection) url.openConnection();
            String outJson = "{\"messages\":[{\"type\":\"mapFeeds\",\"payload\":{\"query\":\""+titleSearch+"\",\"type\":\"address\",\"polygon\":[[55.594511321209005,36.963325500488274],[55.594511321209005,38.28168487548826],[55.9112744330962,38.28168487548826],[55.9112744330962,36.963325500488274],[55.594511321209005,36.963325500488274]]}},{\"type\":\"mapPins\",\"payload\":{\"query\":\"pop\",\"polygon\":[[55.594511321209005,36.963325500488274],[55.594511321209005,38.28168487548826],[55.9112744330962,38.28168487548826],[55.9112744330962,36.963325500488274],[55.594511321209005,36.963325500488274]]}}]}";
            byte[] out = outJson.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            connection.setFixedLengthStreamingMode(length);

            property();

            connection.connect();
            try (OutputStream os = connection.getOutputStream()) {
                os.write(out);
            }

            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "UTF-8"));
                answer = "";
                String line = null;

                while ((line = reader.readLine()) != null) {
                    answer += line;
                }
                reader.close();

            }
            //System.out.println(answer);
            connection.disconnect();

            Gson g = new Gson();
            addresShop = g.fromJson(answer, RestMethodSearchOnMap.class).getMessages().get(0).getPayload().getAddresses().get(0).getAddress().getAddress();


        }
        catch (IOException e){

        }
        return addresShop;
    }

    private void property() throws ProtocolException {
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Cookie","PHPSESSID:6avm7htb95ldu9cqugjpuj6v5v" );
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    }
}


