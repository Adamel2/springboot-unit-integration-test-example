package com.example.demo.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @created 23/12/2020 - 11:35
 * @author  Adham eldda
 * @package com.example.demo.controller
 * @project demotetsing
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {


  @Autowired
  private TestRestTemplate testRestTemplate;


  @Test
  public void contextLoads() throws JSONException {

    String response = this.testRestTemplate.getForObject("/findAll",String.class);

    //      JSONAssert.assertEquals("[{\"id\":\"1001\",\"name\":\"item1\",\"price\":10,\"quantity\""
    // +
    //
    // ":100,\"value\":1000},{\"id\":\"1002\",\"name\":\"item1\",\"price\":20,\"quantity\":100," +
    //
    // "\"value\":2000},{\"id\":\"1003\",\"name\":\"item1\",\"price\":30,\"quantity\":100,\"value\""
    // +
    //
    // ":3000},{\"id\":\"1004\",\"name\":\"item1\",\"price\":40,\"quantity\":100,\"value\":4000}," +
    //        "{\"id\":\"1005\",\"name\":\"item1\",\"price\":50,\"quantity\":100,\"value\":5000}]"
    //      ,response,true);

    //Use /" if your attribute is string value;
    JSONAssert.assertEquals(
        "[{id:\"1001\"},{id:\"1002\"},{id:\"1003\"},{id:\"1004\"},{id:\"1005\"}]", response, false);
  }

}