package ru.vetyugov.kursach.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentsMarks implements Serializable {
    private String fio;
    private List<Integer> marks;

    public StudentsMarks(String fio, List<Integer> marks) {
        this.fio = fio;
        this.marks = marks;
    }
}
