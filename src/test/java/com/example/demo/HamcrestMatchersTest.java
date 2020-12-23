package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.LessThan;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 * @created 23/12/2020 - 12:06
 * @author  Adham eldda
 * @package com.example.demo
 * @project demotetsing
 */
public class HamcrestMatchersTest {


  @Test
  public void learning(){
    List<Integer> numbers = Arrays.asList(12,15,45);

    assertThat(numbers,hasSize(3));
    assertThat(numbers, hasItems(12,45));
    assertThat(numbers, everyItem(greaterThan(11)));
    assertThat(numbers, everyItem(lessThan(46)));
    assertThat("", isEmptyString());
    assertThat("ABCDE", containsString("CDE"));
    assertThat("ABCDE", endsWith("CDE"));
  }
}
