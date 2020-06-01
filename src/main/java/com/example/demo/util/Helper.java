package com.example.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
