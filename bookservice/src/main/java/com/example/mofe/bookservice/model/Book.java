package com.example.mofe.bookservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "TBL_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COL_BOOK_ID")
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name can be at most 100 characters")
    @Column(name = "COL_BOOK_NAME", nullable = false)
    private String name;

    @NotBlank(message = "Weight is mandatory")
    @Column(name = "COL_BOOK_WEIGHT", nullable = false)
    private String weight;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(Integer id, String name, String weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    // Getters and setters
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    // toString
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(weight, book.weight);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }
}
