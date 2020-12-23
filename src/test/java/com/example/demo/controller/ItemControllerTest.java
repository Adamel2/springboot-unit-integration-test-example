package com.example.demo.controller;

import com.example.demo.controller.model.Item;
import com.example.demo.controller.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



/*
 * @created 22/12/2020 - 18:39
 * @author  Adham eldda
 * @package com.example.demo.controller
 * @project demotetsing
 */

@WebMvcTest(value = ItemController.class)
class ItemControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ItemService itemService;

  @Test
  public void getItemsControllerTest() throws Exception {

    RequestBuilder requestBuilder = MockMvcRequestBuilders
      .get("/dummy-item")
      .accept(MediaType.APPLICATION_JSON);
    MvcResult mvcResult =
        mockMvc
            .perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json(
                        "\n"
                            + "{\"id\":\"1234\",\"name\":\"adham\",\"price\":1,\"quantity\":100}"))
            .andReturn();
//    JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), strict);


  }

  @Test
  public void itemFromServiceTest() throws Exception {

    when(itemService.retrievedHardCodeItem())
      .thenReturn(new Item("1234" , "adham", 222,100));
    RequestBuilder requestBuilder = MockMvcRequestBuilders
      .get("/item-from-service")
      .accept(MediaType.APPLICATION_JSON);
    MvcResult result =
        mockMvc
            .perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json(
                        "\n"
                            + "{\"id\":\"1234\",\"name\":\"adham\",\"price\":222,\"quantity\":100}"))
            .andReturn();
//
//    JSONAssert.assertEquals();

  }

  @Test
  public void getAllItemsController() throws Exception{

    when(itemService.findAll()).thenReturn(
      Arrays.asList(new Item("1006", "item2" , 30 , 40)));

    //Build Request
    RequestBuilder requestBuilder = MockMvcRequestBuilders
      .get("/findAll")
      .accept(MediaType.APPLICATION_JSON);

    MvcResult result =
        mockMvc
            .perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json(
                        "[{\"id\":\"1006\",\"name\":\"item2\",\"price\":30,\"quantity\":40,\"value\":0}]"))
            .andReturn();
  }

  @Test
  public void saveItemController() throws Exception {

    Item item = new Item("1010", "adham", 5, 5);
    when(itemService.saveItem(any())).thenReturn(item);

    this.mockMvc
        .perform(
            post("/saveItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"adham\",\"price\": 10,\"quantity\": 5}"))
        .andExpect(status().isCreated())
        .andExpect((jsonPath("$.id").value("1010")));
    }
}