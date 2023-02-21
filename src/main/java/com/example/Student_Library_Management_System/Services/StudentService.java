package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobRequestDTO;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Students;
import com.example.Student_Library_Management_System.Repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepositories studentRepositories;
    public String  createStudent(Students students){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentsVarName(students);// foreign key attribute

        //lets go to student
        students.setCard(card);


        studentRepositories.save(students);

        return "Student And Card Added Successfully";
    }

    public  String findNameByEmail( String email) {
        Students students= studentRepositories.findByEmail(email);
        return  students.getName();
    }

    public String updateMobNo( StudentUpdateMobRequestDTO studentUpdateMobRequestDTO){


        // convert DTO to entity
        Students originalStudent = studentRepositories.findById(studentUpdateMobRequestDTO.getId()).get();
        // changing req para
        originalStudent.setMobNo(studentUpdateMobRequestDTO.getMobNo());
        studentRepositories.save(originalStudent);
        return "Mobile Number updated Successfully";


    }
}
