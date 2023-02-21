package com.example.Student_Library_Management_System.Models;

import javax.persistence.*;

@Entity
@Table(name ="students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private  String email;
    private String  mobNo;
    private  String  country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @OneToOne(mappedBy = "studentsVarName", cascade = CascadeType.ALL)
    private Card card;
    public Students() {
    }

    public Students(int id, String name, String email, String mobNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobNo = mobNo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
