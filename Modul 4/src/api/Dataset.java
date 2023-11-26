package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Dataset {

    public static ArrayList<String> data = new ArrayList<>();
    public Dataset(){

        String supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imt1c2Njd2hvem1mZmZ6YmJocW9tIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDA1NjY5MjEsImV4cCI6MjAxNjE0MjkyMX0.qFrhCXhNp-KlqryS89Fjqnw-GZHPBEUSeBHSoJBJxj4";
        String apiUrl = "https://kusccwhozmfffzbbhqom.supabase.co/storage/v1/object/sign/wordGenerate/dataset.csv?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJ3b3JkR2VuZXJhdGUvZGF0YXNldC5jc3YiLCJpYXQiOjE3MDA3NjE5OTgsImV4cCI6MTcwMzM1Mzk5OH0.rvHmwFwDTt_To7jiYQJZmFjnh-FY90F5nEGEZZ4LHaM&t=2023-11-23T17%3A53%3A17.538Z";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", supabaseKey);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    data.add(values[0]);
                }
                System.out.println("File retrieve successfully.");
            } else {
                System.out.println("Failed to download file. Response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int randomIndex(){
        int random = (int) (Math.random() * data.size());
        return random;
    }

}
