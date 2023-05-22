package ru.vetyugov.kursach.services;

import com.mysql.cj.MysqlConnection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vetyugov.kursach.entities.Student;

import java.sql.*;

@Slf4j
@Service
public class StudentService {
    private static final String url = "jdbc:mysql://localhost:3306/isp_3_19_db";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;

    static {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    public Student getStudentByName(String name, String surname) throws SQLException {
        Statement statement = con.createStatement();
        String sql = "SELECT \n" +
                "\tstudent.`name`,\n" +
                "    student.surname,\n" +
                "    class.`number`,\n" +
                "    class.letter,\n" +
                "    schools.`name` as `schoolName`,\n" +
                "    schools.adress as `schoolAdress`,\n" +
                "    schools.`code` as `schoolCode`\n" +
                "    \n" +
                "FROM student \n" +
                "\tJOIN class ON class.id = student.class_id\n" +
                "\tJOIN schools ON schools.id = class.school_id\n" +
                "WHERE \n" +
                "\tstudent.`name` = '" + name + "' AND student.surname = '" + surname + "'";
        log.debug(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            String sName = resultSet.getString("name");
            String sSurname = resultSet.getString("surname");
            String sNumber = resultSet.getString("number");
            String sLetter = resultSet.getString("letter");
            String sSchoolName = resultSet.getString("schoolName");
            String sSchoolAdress = resultSet.getString("schoolAdress");
            Short sSchoolCode = resultSet.getShort("schoolCode");
            return new Student(sSchoolName, sSchoolCode, sNumber, sLetter, sName, sSurname, sSchoolAdress);

        }
        return null;
    }


}
