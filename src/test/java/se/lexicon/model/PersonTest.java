package se.lexicon.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {

  public Person testObject;

  @BeforeEach
  public void setUp() {
    testObject = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
  }

  @Test
  @Order(1)
  public void testObject_successfully_instantiated() {
    assertEquals("Mehrdad", testObject.getFirstName());
    assertEquals("Javan", testObject.getLastName());
    assertEquals("mehrdad.javan@lexicon.se", testObject.getEmail());
  }

  @Test
  public void test_setFirstName_successfully() {
    testObject.setFirstName("Test FN");
    assertEquals("Test FN", testObject.getFirstName());
  }


  @Test
  @Order(3)
  public void test_equal_successfully() {
    Person expectedResult = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
    assertEquals(expectedResult, testObject);
  }

  @Test
  @Order(2)
  public void test_hashCode_successfully() {
    Person expectedResult = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
    assertEquals(expectedResult.hashCode(), testObject.hashCode());

  }

  @Test
  public void test_hashCode_failed() {
    Person expectedResult = new Person("test", "Javan", "mehrdad.javan@lexicon.se");
    assertNotEquals(expectedResult.hashCode(), testObject.hashCode());
  }

  @Test
  public void test_toString(){
    Person expectedResult = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
    String expectedToStringResult = expectedResult.toString();
    assertEquals(expectedToStringResult, testObject.toString());
  }

}
