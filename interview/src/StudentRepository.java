import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Student {
    public String name;
    public String gender;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute(
                "CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
    }

    public void createStudent(String name, String gender) {
        template.update("INSERT INTO student(id, name, gender) VALUES (?,?,?)", null, name, gender);
    }

    public List<Student> findStudentByName(String nameStartsWith) { 
        // Write your code here return null;
        String xLine = "SELECT name, gender FROM student WHERE name LIKE "+ nameStartsWith +"%";
        List<Student> studentList = new ArrayList<>();
        ResultSet result = template.execute(xLine);
        while (result.next()){
            studentList.add(result.getString("name"),result.getString("gender"));
        }

        return studentList;
    }
}