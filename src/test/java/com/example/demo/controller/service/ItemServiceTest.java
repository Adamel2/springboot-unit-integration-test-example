package com.example.demo.controller.service;

import com.example.demo.controller.model.Item;
import com.example.demo.data.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @created 23/12/2020 - 11:15
 * @author  Adham eldda
 * @package com.example.demo.controller.service
 * @project demotetsing
 */

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {


  @InjectMocks
  private ItemService itemService;

  @Mock
  private ItemRepository itemRepository;

  @Test
  void findAll() {

    when(itemRepository.findAll()).thenReturn(Arrays.asList(
      new Item("1007","item3",10,10)
    ));
    List<Item> itemList = itemService.findAll();

    assertEquals(itemList,itemRepository.findAll());
    assertEquals(100,itemService.findAll().get(0).getValue());


  }
}