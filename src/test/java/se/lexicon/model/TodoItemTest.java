package se.lexicon.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTest {

  private TodoItem testObject;

  @BeforeEach
  public void setUp() {
    Person teamLeader = new Person("team leader", " test", "teamleader@test.se");
    testObject = new TodoItem("Task1", "task1 description", LocalDate.parse("2022-05-10"), false, teamLeader);
  }


  @Test
  public void testObject_successfully_instantiated(){
    assertEquals("Task1", testObject.getTitle());
    assertEquals("task1 description", testObject.getDescription());
    assertEquals(LocalDate.parse("2022-05-10"), testObject.getDeadLine());
  }

  @Test
  public void test_isOverdue_false(){
    assertFalse(testObject.isOverdue());
  }


  @Test
  public void test_isOverdue_true(){
    testObject.setDeadLine(LocalDate.parse("2022-05-01"));
    assertTrue(testObject.isOverdue());
  }

  //...


}
