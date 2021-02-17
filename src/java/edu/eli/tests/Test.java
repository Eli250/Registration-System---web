/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eli.tests;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import edu.eli.util.HibernateInit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author Eli
 */
public class Test {

    public static void main(String[] args) {

        HibernateInit.getSessionFactory();
        createOp(DataOp.INSERT_COURSE);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "16/08/2016";

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        
//        for (String s : ZoneId.getAvailableZoneIds()) {
//            if (s.contains("Africa")) {
//                System.out.println(s);
//            }
//        }
    }

    static void createOp(Operation op) {
        DbSetup dbSetup = new DbSetup(new DriverManagerDestination("jdbc:postgresql://localhost:5432/StudentRegistration", "eli", "eli"),
                op);
        dbSetup.launch();
    }
}

class DataOp {

    public static Operation INSERT_COURSE = Operations.insertInto("courses")
            .columns("code", "name", "credits", "fees")
            .values("CO1", "Advanced Software Modelling", 4, 45000.0)
            .values("CO2", "Web Technology", 3, 60000)
            .values("CO3","Data Structure and Algorithms", 5 , 75000)
            .values("CO4", "Software Testing Techniques", 3, 45000)
            .values("CO5", "Introduction to Bible", 3, 45000)
            .values("CO6", "Introduction to Accounting", 3, 45000)
            .values("CO7", "Mobile Computing", 4, 60000)
            .values("CO8", "Digital Computer Foundamentals", 4, 60000)
            .build();
    public static Operation DELETE_COURSE = Operations.deleteAllFrom("courses");
}
