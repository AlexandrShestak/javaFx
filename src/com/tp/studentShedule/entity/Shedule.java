package com.tp.studentShedule.entity;

import com.tp.course.entity.Course;
import com.tp.user.entity.User;

import java.util.List;

/**
 * Created by shestakam on 22.12.2015.
 */
public class Shedule {

    private User user;
    private int payements;
    private List<Course> courses;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPayements() {
        return payements;
    }

    public void setPayements(int payements) {
        this.payements = payements;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        //courses.add(course);
    }

    public int getCoursesCount() {
        return courses.size();
    }

    public void addAlternativeCourses() {
        //magic
    }
}
