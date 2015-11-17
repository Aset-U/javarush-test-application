package ru.javarush.asui.testapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "to_do_item")
public class ToDoItem implements Serializable {

    private static final long serialVersionUID = 6077493943294924652L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String  description;

    private String  location;
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private Date time;

    @Column(columnDefinition = "enum('PERFORMED','NOT_DONE')")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public ToDoItem() {
    }

    public ToDoItem(String title, String description, String location, Date time, Status status, Category category) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.time = time;
        this.status = status;
        this.category = category;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
