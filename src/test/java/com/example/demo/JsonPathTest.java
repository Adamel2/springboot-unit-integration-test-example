package com.example.demo;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * @created 23/12/2020 - 12:22
 * @author  Adham eldda
 * @package com.example.demo
 * @project demotetsing
 */
public class JsonPathTest {

  @Test
  public void learning(){

    String responseFromService = "[" +
      "  {\"id\": 1000," +
      "  \"name\": \"adham\"," +
      "  \"quantity\": 5}," +
      "  {\"id\": 1001,\n" +
      "    \"name\": \"adham\"," +
      "    \"quantity\": 5}," +
      "  {\"id\": 1002,\n" +
      "    \"name\": \"adham\"," +
      "    \"quantity\": 5}," +
      "  {\"id\": 1003,\n" +
      "    \"name\": \"adham\"," +
      "    \"quantity\": 5}," +
      "  {\"id\": 1004," +
      "    \"name\": \"adham\"," +
      "    \"quantity\": 5}" +
      "]";
    DocumentContext context = JsonPath.parse(responseFromService);
    int length = context.read("$.length()");
    assertThat(length).isEqualTo(5);

    List<Integer> list = context.read("$..id"); //get all id's

    assertThat(list).containsExactly(1000,1001,1002,1003,1004);

    System.out.println(context.read("$.[1]").toString()); //print a first value
    System.out.println(context.read("$.[0:1]").toString());//print objects between 0 to 1
    System.out.println(context.read("$.[?(@.name=='adham')]").toString());//get all objects where name equal adham
    System.out.println(context.read("$.[?(@.quantity==5)]").toString()); //get all objects where quantity equal 5
  }

}
