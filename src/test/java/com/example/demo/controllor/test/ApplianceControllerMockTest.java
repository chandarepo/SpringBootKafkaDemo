package com.example.demo.controllor.test;


import com.example.demo.bean.*;
import com.example.demo.controllor.ApplianceControllor;
import com.example.demo.service.ApplianceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static com.example.demo.util.Helper.toJson;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApplianceControllor.class)
public class ApplianceControllerMockTest {

    public ApplianceControllerMockTest() {
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplianceService service;

    @Test
    public void testCreateApplianceAPI_OK() throws Exception {
        Appliance appliance = new Appliance();
        ApplianceIdentity id = new ApplianceIdentity();
        id.setBrand("Iphone");
        id.setModel("64 GB White");
        id.setSerialNumber("sr11");
        appliance.setApplianceIdentity(id);
        appliance.setBoughtDate(new Date());
        appliance.setStatus(ApplicanceStatus.UNSOLD);
        when(service.createAppliance(appliance)).thenReturn(appliance);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/appliance-demo/create")
                .content(toJson(appliance))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").exists());
    }

    @Test
    public void testUpdateApplianceAPI_OK() throws Exception {
        Appliance appliance = new Appliance();
        ApplianceIdentity id = new ApplianceIdentity();
        id.setBrand("Iphone");
        id.setModel("64 GB White");
        id.setSerialNumber("sr11");
        appliance.setApplianceIdentity(id);
        appliance.setBoughtDate(new Date());
        appliance.setStatus(ApplicanceStatus.SOLD);
        when(service.updateAppliance(appliance)).thenReturn(appliance);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/appliance-demo/update")
                .content(toJson(appliance))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteApplianceAPI_OK() throws Exception {
        Appliance appliance = new Appliance();
        ApplianceIdentity id = new ApplianceIdentity();
        id.setBrand("Iphone");
        id.setModel("64 GB White");
        id.setSerialNumber("sr11");
        appliance.setApplianceIdentity(id);
        appliance.setBoughtDate(new Date());
        appliance.setStatus(ApplicanceStatus.SOLD);
        service.deleteAppliance(appliance);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/appliance-demo/delete")
                .content(toJson(appliance))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }
}
