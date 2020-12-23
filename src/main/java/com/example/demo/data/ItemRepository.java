package com.example.demo.data;

import com.example.demo.controller.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @created 22/12/2020 - 20:16
 * @author  Adham eldda
 * @package com.example.demo.data
 * @project demotetsing
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
