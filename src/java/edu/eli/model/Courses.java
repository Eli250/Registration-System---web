package edu.eli.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Eli
 */
@Entity
public class Courses implements Serializable {
    @Id
    @Column(name = "Code")
    private String c_code;
    @Column(name = "Name")
    private String c_name;
    @Column(name = "Credits")
    private Integer c_credits;
    @Column(name = "Fees")
    private Double c_fees;

    @ManyToMany(mappedBy = "registeredCourses")
    private List<Student> student;
    
    public Courses() {
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Integer getC_credits() {
        return c_credits;
    }

    public void setC_credits(Integer c_credits) {
        this.c_credits = c_credits;
    }

    public Double getC_fees() {
        return c_fees;
    }

    public void setC_fees(Double c_fees) {
        this.c_fees = c_fees;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return c_code + " - " + c_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.c_code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Courses other = (Courses) obj;
        if (!Objects.equals(this.c_code, other.c_code)) {
            return false;
        }
        return true;
    }
    
}
