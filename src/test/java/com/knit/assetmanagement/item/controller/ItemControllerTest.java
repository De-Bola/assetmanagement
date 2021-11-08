package com.knit.assetmanagement.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knit.assetmanagement.item.model.Item;
import com.knit.assetmanagement.item.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ItemService itemService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void ShouldReturnCreatedItem() throws Exception{
        Item item = new Item ();
        item.setComment("");
        item.setAsset_id(90210L);
        item.setCreate_date("");
        item.setAsset_quantity(5L);
        item.setDescription("null");
        item.setManufacturer("");
        item.setModel("nokia");
        item.setStatus("active");
        item.setOperator_id("1");
        item.setProduct_number("");
        item.setVendor_id(72634262L);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/add-item").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isCreated());
    }
}
