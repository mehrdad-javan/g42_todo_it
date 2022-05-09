package se.lexicon.model;

import java.util.Objects;

public class TodoItemTask {

  private int id;
  private boolean assigned;
  private TodoItem todoItem;
  private Person assignee;

  public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
    this(todoItem, assignee);
    this.id = id;
  }

  public TodoItemTask(TodoItem todoItem, Person assignee) {
    setTodoItem(todoItem);
    setAssignee(assignee);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isAssigned() {
    return assigned;
  }

  public void setAssigned(boolean assigned) {
    this.assigned = assigned;
  }

  public TodoItem getTodoItem() {
    return todoItem;
  }

  public void setTodoItem(TodoItem todoItem) {
    if (todoItem == null) throw new IllegalArgumentException("TodoItem is null");
    this.todoItem = todoItem;
  }

  public Person getAssignee() {
    return assignee;
  }

  public void setAssignee(Person assignee) {
    this.assignee = assignee;
    setAssigned(this.assignee != null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TodoItemTask that = (TodoItemTask) o;
    return id == that.id && assigned == that.assigned && Objects.equals(todoItem, that.todoItem) && Objects.equals(assignee, that.assignee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, assigned, todoItem, assignee);
  }

  @Override
  public String toString() {
    return "TodoItemTask{" +
            "id=" + id +
            ", assigned=" + assigned +
            ", todoItem=" + todoItem +
            ", assignee=" + assignee +
            '}';
  }
}
