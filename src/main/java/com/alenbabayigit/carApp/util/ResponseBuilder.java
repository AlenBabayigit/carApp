package com.alenbabayigit.carApp.util;

import java.util.HashMap;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static ResponseEntity<?> success(String message, Object data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", true);
        hashMap.put("message", message);
        hashMap.put("data", data);
        return ResponseEntity.ok(hashMap);

    }

    public static ResponseEntity<?> error(String message) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", false);
        hashMap.put("message", message);
        hashMap.put("data", null);
        return ResponseEntity.ok(hashMap);
    }

}
