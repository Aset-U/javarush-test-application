package ru.javarush.asui.testapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Category implements Serializable {

    private static final long serialVersionUID = 4879019423038517048L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ToDoItem> toDoItems = new HashSet<ToDoItem>();

    public Category() {
    }

    public Category(String name, Set<ToDoItem> toDoItems) {
        this.name = name;
        this.toDoItems = toDoItems;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(Set<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }
}
