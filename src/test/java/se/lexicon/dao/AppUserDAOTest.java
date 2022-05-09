package se.lexicon.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.impl.AppUserDAOCollection;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

public class AppUserDAOTest {

  private AppUserDAO testObject;

  @BeforeEach
  public void setUp(){
    testObject = new AppUserDAOCollection();
  }

  @Test
  public void test_add_AppUser_And_FindByUsername(){
    AppUser testAppUser = new AppUser("admin","123456", AppRole.APP_ADMIN);
    AppUser createdAppUser = testObject.persist(testAppUser);
    assertEquals(1, testObject.findAll().size());

    AppUser findUser = testObject.findByUsername("admin");
    assertEquals(testAppUser, findUser);

    AppUser findUser123 = testObject.findByUsername("admin123");
    assertNull(findUser123);
  }
}
