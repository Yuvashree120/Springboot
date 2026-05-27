package com.eduhub.eduhub_backend.component;

import org.springframework.stereotype.Component;

@Component
public class CourseService {
    private int courseCode;
    private String subName;
    private int credits;
   public CourseService(){

   }
    public CourseService(int courseCode,String subName, int credits){
        this.courseCode = courseCode;
        this.subName=subName;
        this.credits=credits;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public String getSubName() {
        return subName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode= courseCode;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
