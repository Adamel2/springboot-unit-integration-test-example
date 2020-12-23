package com.example.demo.data;

import com.example.demo.controller.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @created 23/12/2020 - 11:24
 * @author  Adham eldda
 * @package com.example.demo.data
 * @project demotetsing
 */
@DataJpaTest
class ItemRepositoryTest {


  @Autowired
  private ItemRepository itemRepository;


  @Test
  public void findAll(){

    List<Item> items = itemRepository.findAll();

    assertEquals(5,items.size());
  }

}