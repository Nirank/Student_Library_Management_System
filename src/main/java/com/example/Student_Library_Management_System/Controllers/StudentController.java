package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobRequestDTO;
import com.example.Student_Library_Management_System.Models.Students;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Students students){

        return studentService.createStudent(students);
    }
    @GetMapping("/get_user")
    public  String getNameByEmail(@RequestParam("email") String email) {
        return studentService.findNameByEmail(email);
    }

    @PutMapping("/update_MobNo")
    public String updateMobNo(@RequestBody StudentUpdateMobRequestDTO studentUpdateMobRequestDTO){
        return studentService.updateMobNo(studentUpdateMobRequestDTO);
    }
}
