package jokes.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName) 
            throws IllegalArgumentException, IOException {
        
        if (urlString == null || urlString.trim().isEmpty()) {
            throw new IOException("URL cannot be null or empty");
        }
        if (attributeName == null || attributeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Attribute name cannot be null or empty");
        }
        
        String jsonResponse = fetchJsonFromUrl(urlString);
        String attributeValue = extractAttributeFromJson(jsonResponse, attributeName);
        
        return attributeValue;
    }

    private String fetchJsonFromUrl(String urlString) throws IOException {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new IOException("Invalid URL: " + urlString, e);
        }
        
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP request failed with response code: " + responseCode);
            }
            
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
            }
            
            return content.toString();
            
        } catch (IOException e) {
            throw new IOException("Failed to fetch data from URL: " + urlString, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public String extractAttributeFromJson(String jsonString, String attributeName) 
            throws IllegalArgumentException, IOException {
        
        try {
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(jsonString);
            
            if (!(parsed instanceof JSONObject)) {
                throw new IllegalArgumentException("JSON response is not a valid object");
            }
            
            JSONObject jsonObject = (JSONObject) parsed;
            
            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response");
            }
            
            Object value = jsonObject.get(attributeName);
            if (value == null) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' has null value");
            }
            
            return value.toString();
            
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }
}