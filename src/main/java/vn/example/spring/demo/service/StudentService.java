package vn.example.spring.demo.service;


import vn.example.spring.demo.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(Long id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudent(Long id);

    List<Student> getAllStudnetsNotFirstName(String firstName);
}
