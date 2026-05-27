package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Courses")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    @GetMapping("Course")
    public ResponseEntity<List<CourseService>>getCourse() {
        List<CourseService> CourseList = new ArrayList<>();
        CourseList.add(new CourseService(115, "Springboot", 8));
        CourseList.add(new CourseService(152,"Computer networks",7));
        CourseList.add(new CourseService(167,"Computer",5));
        CourseList.add(new CourseService(182,"python",7));
        CourseList.add(new CourseService(556,"fullstack",9));

        return new ResponseEntity<>(CourseList, HttpStatus.OK);
    }
    @GetMapping("coursequery")
    public ResponseEntity<CourseService> courseResponseEntity(@RequestParam int coursecode,
                                                       @RequestParam String subName,
                                                       @RequestParam int credits){

        CourseService course = new CourseService(coursecode,subName,credits);
        return ResponseEntity.ok(course);
    }

    @PostMapping("createcourse")
    public ResponseEntity<CourseService> createCourse(@RequestBody CourseService courseService){

        System.out.println(courseService.getCourseCode());
        System.out.println(courseService.getSubName());
        System.out.println(courseService.getCredits());
        return ResponseEntity.ok(courseService);
    }

    @PutMapping("{coursecode}/update")
    public ResponseEntity updateCourse(@PathVariable("coursecode") int coursecode,
                                       @RequestBody CourseService courseService){
        return ResponseEntity.accepted().body(courseService);
    }
    @DeleteMapping("{coursecode}/delete")
    public ResponseEntity deleteCourse(@PathVariable("coursecode") int coursecode){
        return ResponseEntity.ok(courseService);
    }
}