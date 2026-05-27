package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("Student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Yuva", "Shree");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
//display all the StudentList
    @GetMapping("Students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Akshaya", "sri"));
        studentList.add(new Student(2, "Ram", "Kumar"));
        studentList.add(new Student(3, "Harini", "CH"));
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
//"Display particular id,name"
    @GetMapping("{id}/{first-Name}/{last-Name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-Name") String firstName,
                                                       @PathVariable("last-Name") String lastName
    ) {
        Student student = new Student(studentId, firstName, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("query")
    public ResponseEntity<Student> studentResponseVariable(@RequestParam int studentId,
                                                           @RequestParam String firstName,
                                                           @RequestParam String lastName)
    {
        Student student = new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody  Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);

    }
    @PutMapping("{id}/update")
    public ResponseEntity updateStudent(@PathVariable("id") int studentId,
                                        @RequestBody Student student){
        return ResponseEntity.accepted().body(student);
}
}