package edu.miu.cs.cs425.webapps.eregistrar.repository;

import edu.miu.cs.cs425.webapps.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select * from students s where s.student_number like %:keyword% or s.first_name like %:keyword% or s.last_name like %:keyword% ", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
