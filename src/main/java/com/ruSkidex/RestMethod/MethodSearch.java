package com.ruSkidex.RestMethod;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MethodSearch {
    HttpURLConnection connection;
    private class search{
        boolean success;
        Data data;
    }
    private  class Data{
        public ArrayList<Product> productCardsSnippets;
    }

    private  class Product{
        long id;
        String title;
    }


    public String search(String searchObject) throws IOException {
        String answer = "";
        String firstProductString = null;
        try {
            URL url = new URL("https://t.skidex.ru/site/api/product-cards?query="+searchObject);
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


            Gson g = new Gson();
            search search1 = g.fromJson(answer, search.class);
            //System.out.println(search1.data.productCardsSnippets.get(0).title);
            boolean status = search1.success;
            if(search1.data.productCardsSnippets.size()>0){
                Product firstProduct = search1.data.productCardsSnippets.get(0);
                //System.out.println(firstProduct);
                firstProductString = firstProduct.title.trim();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstProductString;
    }

    private void property() throws ProtocolException {
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Cookie","PHPSESSID:6avm7htb95ldu9cqugjpuj6v5v" );
    }
}

