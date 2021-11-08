package com.knit.assetmanagement.vendor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knit.assetmanagement.vendor.Exceptions.VendorNoFoundException;
import com.knit.assetmanagement.vendor.model.Vendor;
import com.knit.assetmanagement.vendor.service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VendorController.class)
public class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VendorService vendorService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void ShouldReturnNewVendor() throws Exception, VendorNoFoundException {
        given(vendorService.getVendorByName(anyString())).willReturn(
                new Vendor("Jim", "Tallinn", "1-555-8784", "someone@something.eu"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/get-vendor-by-name/Jim")).
                andExpect(status().isOk()).andExpect(jsonPath("name").value("Jim"));
    }

    @Test
    public void ShouldReturnCreatedVendor() throws Exception{
        Vendor vendor = new Vendor("Jonson", "Demian", "1-555-8784", "someone@something.eu");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/add-vendor").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(vendor)))
                .andExpect(status().isCreated());

    }
}
