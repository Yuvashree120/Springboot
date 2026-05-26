package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import com.eduhub.eduhub_backend.component.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    /*
    //@Autowired //dependency injection

    CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping("get-course")
    public String getCourse(){
        return courseService.getCourse();
    }
    */
    DepartmentService departmentService;
    public CourseController(DepartmentService departmentService){
        this.departmentService = departmentService;

    }
    @GetMapping("get-depart")
    public String getDepartment(){
        return departmentService.getDepartment();
    }
}