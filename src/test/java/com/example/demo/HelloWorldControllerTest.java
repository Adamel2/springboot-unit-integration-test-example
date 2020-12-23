package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
 * @created 22/12/2020 - 17:21
 * @author  Adham eldda
 * @package com.example.demo
 * @project demotetsing
 */


@WebMvcTest(value = HelloWorldController.class)
class HelloWorldControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void helloWorld_basicTest() throws Exception {
    //Make a Request "/hello-world"
    RequestBuilder requestBuilder =
      MockMvcRequestBuilders.get("/hello-world")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(requestBuilder)
      .andExpect(status().isOk())
      .andExpect(content().string("Hello World!"))
      .andReturn();

    //verify
    //not needed because use the mvc Result
    //assertEquals("Hello World!" , mvcResult.getResponse().getContentAsString());
  }
}