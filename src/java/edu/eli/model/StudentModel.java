package edu.eli.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Eli
 */
public class StudentModel {

    private String sIdInput = "";
    private String sNameInput = "";
    private String genderInput = "";
    private String dobInput = "";
    private LocalDate dobValue;
    private String dateMessage = "";
    private String idMsg = "";
    private String nameMsg = "";
    private String genderMsg = "";

    private final Student st = new Student();

    public void applyRequestValue(HttpServletRequest request) {
        sIdInput = request.getParameter("sid");
        sNameInput = request.getParameter("snames");
        genderInput = request.getParameter("sgender");
        dobInput = request.getParameter("sdob");
    }

    public boolean convertValues() {
        boolean error = true;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            dobValue = LocalDate.parse(dobInput, formatter);
            error = false;
        } catch (Exception e) {
            dateMessage = "Date must be in this format 'd/MM/yyyy'";
            return error;
        }
        return error;
    }

    public boolean validateValues() {
        boolean error = false;
        if (sIdInput.isEmpty() || "".equals(sIdInput)) {
            idMsg = "ID is required!";
            error = true;
        }
        if (sIdInput.length() != 5) {
            idMsg = "Student ID must be 5 digits!";
            error = true;
        }
        if (sNameInput.isEmpty() || sNameInput == null) {
            error = true;
            nameMsg = "Student Name is required";
        }
        if (!genderInput.toUpperCase().equals("MALE") && !genderInput.toUpperCase().equals("FEMALE")) {
            error = true;
            genderMsg = "Gender must be MALE or FEMALE";
        }
        return error;
    }
    public boolean isExist(String code) {
        Student s = new Student();
        boolean isexist = false;
        List<Courses> courseList =s.getRegisteredCourses();
        for (Courses c : courseList) {
            if (c.getC_code()==code) {
                isexist = true;
            }
        }
        return isexist;
    }   
    public boolean applyModelValues(){
        boolean error = false;
        try {
            st.setsId(sIdInput);
            st.setNames(sNameInput);
            st.setGender(Gender.valueOf(genderInput));
            st.setDateOfBirth(dobValue);
        } catch (Exception e) {
            error = true;
        }
        return error;
    }
    public String getsIdInput() {
        return sIdInput;
    }

    public void setsIdInput(String sIdInput) {
        this.sIdInput = sIdInput;
    }

    public String getsNameInput() {
        return sNameInput;
    }

    public void setsNameInput(String sNameInput) {
        this.sNameInput = sNameInput;
    }

    public String getGenderInput() {
        return genderInput;
    }

    public void setGenderInput(String genderInput) {
        this.genderInput = genderInput;
    }

    public String getDobInput() {
        return dobInput;
    }

    public void setDobInput(String dobInput) {
        this.dobInput = dobInput;
    }

    public LocalDate getDobValue() {
        return dobValue;
    }

    public void setDobValue(LocalDate dobValue) {
        this.dobValue = dobValue;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }

    public String getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(String idMsg) {
        this.idMsg = idMsg;
    }

    public String getNameMsg() {
        return nameMsg;
    }

    public void setNameMsg(String nameMsg) {
        this.nameMsg = nameMsg;
    }

    public String getGenderMsg() {
        return genderMsg;
    }

    public void setGenderMsg(String genderMsg) {
        this.genderMsg = genderMsg;
    }

}
