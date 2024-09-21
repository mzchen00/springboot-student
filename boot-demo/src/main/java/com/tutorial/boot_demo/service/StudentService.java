package com.tutorial.boot_demo.service;

import com.tutorial.boot_demo.dao.Student;
import com.tutorial.boot_demo.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentDTO getStudentById(long id);

    Long addNewStudent(StudentDTO studentDTO);
}
