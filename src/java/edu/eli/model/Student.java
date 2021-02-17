package edu.eli.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Eli
 */
@Entity
public class Student implements Serializable {
    @Id
    @Column(name = "ID")
    private String sId;
    @Column(name = "Names")
    private String names;
    @Column(name = "Gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "DoB")
    private LocalDate dateOfBirth;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Registration",
            joinColumns = {@JoinColumn(name = "Code")},
            inverseJoinColumns = {@JoinColumn(name = "ID")})
    private List<Courses> registeredCourses = new ArrayList();
    
    public Student() {
    }

    public void registerCourse(Courses course){
        registeredCourses.add(course);
    }
    
    public void removeCourse(Courses course){
        registeredCourses.remove(course);
    }
    
    public boolean isExist(String code){
        boolean isexist=false;
        for (Courses c : registeredCourses) {
            if(c.getC_code().equals(code))
                isexist = true;
        }
        return isexist;
    }
    
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Courses> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Courses> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public String toString() {
        return sId + " - " + names;
    }
        
}
