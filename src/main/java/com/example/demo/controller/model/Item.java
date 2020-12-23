package com.example.demo.controller.model;

/*
 * @created 22/12/2020 - 18:36
 * @author  Adham eldda
 * @package com.example.demo.controller.model
 * @project demotetsing
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity

public class Item {

  @Id
  private String id;

  private String name;
  private int price ;
  private int quantity;

  @Transient
  private int value;

  public Item(){}
  public Item(String id, String name, int price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Item{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", price=" + price +
      ", quantity=" + quantity +
      '}';
  }
}