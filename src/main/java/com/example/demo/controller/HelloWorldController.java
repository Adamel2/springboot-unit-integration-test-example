package com.example.demo.controller;

/*
 * @created 22/12/2020 - 17:16
 * @author  Adham eldda
 * @package com.example.demo
 * @project demotetsing
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


  @GetMapping("/hello-world")
  public String helloWorld(){

    return "Hello World!";
  }

}
