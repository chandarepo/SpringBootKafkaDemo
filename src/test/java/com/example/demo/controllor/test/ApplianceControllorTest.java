package com.example.demo.controllor.test;


import com.example.demo.controllor.ApplianceControllor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ApplianceControllorTest {
    @Autowired
    private ApplianceControllor controller;

    @Test
    public void contexLoads() throws Exception {
        assertNotNull(controller);
    }
}
