package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private  int pages;
    private  boolean issued;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;


    @ManyToOne
    @JoinColumn
    private Author author;

    // book is also child wrt Card
    @ManyToOne
    @JoinColumn
    private Card card;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> listOfTransaction = new ArrayList<>();


    public List<Transaction> getListOfTransaction() {
        return listOfTransaction;
    }

    public void setListOfTransaction(List<Transaction> listOfTransaction) {
        this.listOfTransaction = listOfTransaction;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }



    public Book() {
    }

    public Book(int id, String name, int pages, Genre genre, Author author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.genre = genre;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
