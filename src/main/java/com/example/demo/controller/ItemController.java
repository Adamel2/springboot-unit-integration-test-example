package com.example.demo.controller;

/*
 * @created 22/12/2020 - 18:35
 * @author  Adham eldda
 * @package com.example.demo.controller
 * @project demotetsing
 */

import com.example.demo.controller.model.Item;
import com.example.demo.controller.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {


  @Autowired
  private ItemService itemService;

  @GetMapping(path = "/dummy-item")
  public Item getItems(){

    return new Item("1234" , "adham", 1,100);

  }

  @GetMapping(path = "/item-from-service")
  public Item itemFormService(){

    return itemService.retrievedHardCodeItem();
  }

  @GetMapping(path = "/findAll")
  public List<Item> findAll(){

  return itemService.findAll();
  }

  @PostMapping(path = "/saveItem")
  public ResponseEntity<Item> saveItem(@RequestBody Item item){

    return ResponseEntity.status(HttpStatus.CREATED).body(itemService.saveItem(item));

  }
}
