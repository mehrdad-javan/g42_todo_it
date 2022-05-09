package se.lexicon.dao.impl;

import se.lexicon.dao.AppUserDAO;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDAOCollection implements AppUserDAO {

  private List<AppUser> appUsers;

  public AppUserDAOCollection() {
    appUsers = new ArrayList<>();
  }

  // implement all CRUD operations

  @Override
  public AppUser persist(AppUser appUser) {
    if (appUser == null) throw new IllegalArgumentException("AppUser is null");
    if (findByUsername(appUser.getUsername()) != null)
      throw new IllegalArgumentException("Username" + appUser.getUsername() + " is already taken");

    appUsers.add(appUser);
    return appUser;
  }

  @Override
  public AppUser findByUsername(String username) {
    if (username == null) throw new IllegalArgumentException("Username is null");
    /*for (AppUser element : appUsers) {
      if (element.getUsername().equalsIgnoreCase(username)){
        return  element;
      }
    }
    return null;*/

    return appUsers.stream()
            .filter(appUser -> appUser.getUsername().equalsIgnoreCase(username))
            .findFirst().orElse(null);
  }

  @Override
  public List<AppUser> findAll() {
    return appUsers;
  }

  @Override
  public void remove(String username) {
    // step1: find by username
    // step2: if data exists
    // step3: remove it
    AppUser findUser = findByUsername(username);
    if (findUser != null) appUsers.remove(findUser);
  }


}
