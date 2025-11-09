package com.songguesser.bff.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Base64;
import java.util.Map;

public class JwtUtils {
    public static String extractSub(String token) {
        try {
            String[] parts = token.split("\\.");
            String payloadJson = new String(Base64.getDecoder().decode(parts[1]));
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> payload = mapper.readValue(payloadJson, Map.class);
            return (String) payload.get("sub");
        } catch (Exception e) {
            return null;
        }
    }
}
