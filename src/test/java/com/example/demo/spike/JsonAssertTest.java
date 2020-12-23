package com.example.demo.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import org.skyscreamer.jsonassert.JSONAssert;

/*
 * @created 22/12/2020 - 19:09
 * @author  Adham eldda
 * @package com.example.demo.spike
 * @project demotetsing
 */
public class JsonAssertTest {

  String actualResponse = "\n" +
    "{\"id\":\"324wldni23ud\",\"name\":\"adham\",\"price\":222,\"quantity\":100}";

  @Test
  public void jsonAssert() throws JSONException {

    String expectedResponse = "{\"id\":\"324wldni23ud\",\"name\":\"adham\",\"price\":222,\"quantity\":100}" ;
    JSONAssert.assertEquals(expectedResponse, actualResponse,true);
  }
}
