package com.apurv.test.repository;

import com.apurv.test.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @EntityGraph(attributePaths = "subjects")
    @Query("select s from Student s")
    List<Student> findAllStudents();
}
