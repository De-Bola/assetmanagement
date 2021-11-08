package com.knit.assetmanagement.item.service;

import com.knit.assetmanagement.item.exception.ItemNotFoundException;
import com.knit.assetmanagement.item.model.Item;
import com.knit.assetmanagement.item.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    ItemService(ItemRepository repository){
        this.itemRepository = repository;
    }
    public Item addItem(Item item) {
        // there's no need to check if item already exists since item contents can be duplicated by nature
        // and id is already auto-generated
        item.setCreate_date(LocalDate.now().toString());
        return itemRepository.save(item);
    }

    public Item editItem(Item item) throws ItemNotFoundException {
        Item existingItem;
        // editing will require PK
        if(itemRepository.findById(item.getId()).isEmpty()) {
            throw new ItemNotFoundException("No such Item!");
        } else
        {
           existingItem = itemRepository.findById(item.getId()).get();
           overwriteExistingItem(item, existingItem);
            return existingItem;
        }
    }

    private void overwriteExistingItem(Item item, Item newItem) {
        newItem.setVendor_id(item.getVendor_id());
        newItem.setStatus(item.getStatus());
        newItem.setProduct_number(item.getProduct_number());
        newItem.setOperator_id(item.getOperator_id());
        newItem.setModel(item.getModel());
        newItem.setManufacturer(item.getManufacturer());
        newItem.setDescription(item.getDescription());
        newItem.setAsset_quantity(item.getAsset_quantity());
        newItem.setLast_updated(LocalDate.now().toString());
        newItem.setAsset_id(item.getAsset_id());
        newItem.setComment(item.getComment());

        itemRepository.save(newItem);
    }
}
