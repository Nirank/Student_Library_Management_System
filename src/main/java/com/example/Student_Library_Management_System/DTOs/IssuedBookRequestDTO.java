package com.example.Student_Library_Management_System.DTOs;

public class IssuedBookRequestDTO {
    private  int cardID;
    private  int bookID;

    public IssuedBookRequestDTO() {
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
