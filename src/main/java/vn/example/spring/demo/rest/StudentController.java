package vn.example.spring.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import vn.example.spring.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import vn.example.spring.demo.dao.StudentDAO;
import vn.example.spring.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/not-first-name/{firstName}")
    public List<Student> getAll(@PathVariable String firstName)
    {

        return studentService.getAllStudnetsNotFirstName(firstName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id)
    {
        Student student = studentService.getStudentById(id);
        if(student != null)
        {
            return ResponseEntity.ok(student);
        }
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        student = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id ,@RequestBody Student student)
    {
        Student studentExist = studentService.getStudentById(id);
        if(studentExist != null)
        {
            studentExist.setFirstName(student.getFirstName());
            studentExist.setLastName(student.getLastName());
            studentExist.setEmail(student.getEmail());
            studentService.updateStudent(studentExist);
            return ResponseEntity.ok().body(studentExist);
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        if(studentService.getStudentById(id) != null)
        {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }

}
