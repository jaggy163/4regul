package Parsing;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parse01 {
    public static void main(String[] args) throws IOException {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line, all = "", str, report = "";
        url = new URL("https://vk.com/id265551455");
        HttpsURLConnection httpsurlConnection = (HttpsURLConnection) url.openConnection();
//        System.out.println(httpurlConnection.getRequestMethod());
//        System.out.println(httpurlConnection.getResponseMessage());
//
//        Map<String, List<String>> myMap = httpurlConnection.getHeaderFields();
//        Set<String> myField = myMap.keySet();
//        System.out.println("\nДалее следует заголовок:");
//
//        // Вывести все ключи и значения из заголовка
//        for (String k : myField) {
//            System.out.println("Ключ: " + k + " Значение: "
//                    + myMap.get(k));
//        }

        br = new BufferedReader(new InputStreamReader(httpsurlConnection.getInputStream()));
        while((line=br.readLine()) != null) {
            all+=line;
        }
        System.out.println(all);

    }
}
