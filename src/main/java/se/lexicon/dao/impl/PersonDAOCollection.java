package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDAO;
import se.lexicon.dao.sequencer.PersonSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {

  private List<Person> people;

  public PersonDAOCollection() {
    people = new ArrayList<>();
  }


  @Override
  public Person persist(Person person) {
    if (person == null) throw new IllegalArgumentException("Person is null");
    if (findByEmail(person.getEmail()) != null)
      throw new IllegalArgumentException("Email" + person.getEmail() + " is already taken");
    person.setId(PersonSequencer.nextId());
    people.add(person);
    return person;
  }

  @Override
  public Person findById(int id) {
    if (id == 0) throw new IllegalArgumentException("Id is zero");
    // Imperative
    /*for (Person element : people) {
      if (element.getId() == id){
        return element;
      }
    }
    return null;*/

    // Declarative
    return people.stream()
            .filter(person -> person.getId() == id)
            .findFirst().orElse(null);

  }

  @Override
  public Person findByEmail(String email) {
    if (email == null) throw new IllegalArgumentException("Email is null");
    return people.stream()
            .filter(person -> person.getEmail().equalsIgnoreCase(email))
            .findFirst().orElse(null);
  }

  @Override
  public Person findByUsername(String username) {
    if (username == null) throw new IllegalArgumentException("username is null");
    return people.stream()
            .filter(person -> person.getCredentials().getUsername().equalsIgnoreCase(username))
            .findFirst().orElse(null);
  }

  @Override
  public List<Person> findAll() {
    return people;
  }

  @Override
  public void remove(int id) {
    Person result = findById(id);
    if (result != null) people.remove(result);
  }
}
