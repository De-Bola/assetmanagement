package com.knit.assetmanagement.item.repo;

import com.knit.assetmanagement.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findItemByFilter(String filter);
}
