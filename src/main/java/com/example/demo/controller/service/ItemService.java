package com.example.demo.controller.service;

import com.example.demo.controller.model.Item;
import com.example.demo.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 22/12/2020 - 19:34
 * @author  Adham eldda
 * @package com.example.demo.controller.service
 * @project demotetsing
 */
@Service
public class ItemService {

  @Autowired
  private ItemRepository itemRepository;


  public Item retrievedHardCodeItem() {
    return new Item("1234" , "adham", 222,100);
  }
  public List<Item> findAll(){

    List<Item> list = itemRepository.findAll();

    for (Item item : list) {
      item.setValue(item.getPrice() * item.getQuantity());
    }

    return list;
  }

  public Item saveItem(Item item){

    item.setId("1010");
    itemRepository.save(item);
    return item;

  }
}
