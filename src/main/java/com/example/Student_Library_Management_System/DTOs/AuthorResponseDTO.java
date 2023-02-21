package com.example.Student_Library_Management_System.DTOs;

import java.util.List;

public class AuthorResponseDTO {
    private String name;
    private  int age;
    private double rating;
    private  String country;
    List<BookResponseDTO>  booksWritten;

    public AuthorResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookResponseDTO> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResponseDTO> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
