package vn.example.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.example.spring.demo.entity.Student;

import java.util.List;



@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {
    // code
    // truy van bang firstName
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // tim kiem sinh vien khac voi firstName
    public List<Student> findByFirstNameIsNotContaining(String firstName);

    @Query("SELECT s FROM Student s WHERE s.firstName not like ?1")
    public List<Student> findByFirstNameNot(String firstName);


}
