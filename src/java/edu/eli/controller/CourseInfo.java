/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eli.controller;

import edu.eli.model.Courses;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eli
 */
public class CourseInfo {

    private List<Courses> courseList = new ArrayList<>();

    public void addCourse(Courses cs) {
        courseList.add(cs);
    }

    public void removeCourse(Courses cs) {
        courseList.remove(cs);
    }

    public List<Courses> getCourseList() {
        return courseList;
    }

    public Integer countCourses() {
        return courseList.size();
    }

    public boolean isExist(String code) {
        boolean isexist = false;
        for (Courses c : courseList) {
            if (c.getC_code()==code) {
                isexist = true;
            }
        }
        return isexist;
    }

    public Integer calculateCredits() {
        int credits = 0;
        for (Courses c : courseList) {
            credits = c.getC_credits() + credits;
        }
        return credits;
    }

    public String totalFees() {
        Double total = 0.0;
        for (Courses c : courseList) {
            total = c.getC_fees() + total;
        }
        DecimalFormat df = new DecimalFormat("###,### RWF");
        return df.format(total);
    }

    @Override
    public String toString() {
        return "CourseInfo{" + "courseList=" + courseList + '}';
    }

}
