package ru.vetyugov.kursach.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    private  String schoolAdress;
    private String school;
    private Short schoolIndex;
    private String classNumber;
    private String classLetter;
    private String name;
    private String surname;

    public Student(String school, Short schoolIndex, String classNumber, String classLetter, String name, String surname,String schoolAdress) {
        this.schoolAdress = schoolAdress;
        this.school = school;
        this.schoolIndex = schoolIndex;
        this.classNumber = classNumber;
        this.classLetter = classLetter;
        this.name = name;
        this.surname = surname;
    }
}
