package com.book.api.bootrestbook.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Books 
 {
    
    @Id
    private Long id;
    private String title;
    
    private String author;

    public Books(String author, Long id, String title)
     {
        this.author = author;
        this.id = id;
        this.title = title;
    }

   

    public Books() 
    {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
 }
 
    