package vn.example.spring.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.example.spring.demo.dao.StudentDAO;
import vn.example.spring.demo.entity.Student;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO)
    {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentDAO.deleteById(id);
    }

    @Override
    public List<Student> getAllStudnetsNotFirstName(String firstName) {
        return studentDAO.findByFirstNameIsNotContaining(firstName);
    }
}
