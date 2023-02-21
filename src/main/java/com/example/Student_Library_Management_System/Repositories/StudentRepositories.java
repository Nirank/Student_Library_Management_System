package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepositories extends JpaRepository<Students, Integer> {
    List<Students> findByCountry(String country);
    Students findByEmail (String email);
}
