package com.example.demo.backend;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class RecaptchaService {
    
    private final String SECRET_KEY = "6Lfk3SIsAAAAAJqao3jJRTNTbEi7f8AswXhpKjI6"; 
    
    public boolean verify (String responseString) {
    try {
        String url = "https://www.google.com/recaptcha/api/siteverify";

        RestTemplate rest = new RestTemplate();

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("secret", SECRET_KEY);
        body.add("response", responseString);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> googleResponse =
                rest.postForEntity(url, requestEntity, Map.class);

        Map<String, Object> json = googleResponse.getBody();
        return (Boolean) json.get("success");

    } catch (Exception e) {
        System.out.println("Recaptcha verify failed: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}

}
