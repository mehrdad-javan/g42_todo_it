package se.lexicon.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTaskTest {


  static final Person DEV1 = new Person("dev1", "dev11", "dev1@test.se");
  static final Person DEV2 = new Person("dev2", "dev2", "dev2@test.se");
  static final Person TEAM_LEADER = new Person("Team Liader", "test", "teamleader@test.se");
  static final TodoItem TASK1 = new TodoItem("Task1", "test description", LocalDate.parse("2022-05-10"), false, TEAM_LEADER);
  static TodoItem TASK2 = new TodoItem("Task2", "test description", LocalDate.parse("2022-05-02"), false, TEAM_LEADER);


  private TodoItemTask testObject;


  @BeforeEach
  public void setUp() {
    testObject = new TodoItemTask(TASK1, DEV1);
  }

  @Test
  public void testObject_successfully_instantiated() {
    assertEquals(TASK1, testObject.getTodoItem());
    assertEquals(DEV1, testObject.getAssignee());

    assertNotEquals(TASK2, testObject.getTodoItem());
  }

  @Test
  public void test_isAssigned_true(){
    assertTrue(testObject.isAssigned());
  }

  //...
}
