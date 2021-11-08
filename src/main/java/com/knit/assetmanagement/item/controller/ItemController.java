package com.knit.assetmanagement.item.controller;

import com.knit.assetmanagement.item.model.Item;
import com.knit.assetmanagement.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService service){
        this.itemService = service;
    }

    @PostMapping(value = "/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public Item addVendor(@RequestBody Item item) {
        return itemService.addItem(item);
    }
}
