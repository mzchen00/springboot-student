package com.tutorial.boot_demo.service;

import com.tutorial.boot_demo.converter.StudentConverter;
import com.tutorial.boot_demo.dao.Student;
import com.tutorial.boot_demo.dao.StudentRespository;
import com.tutorial.boot_demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRespository studentRespository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRespository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertToStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> studentList = studentRespository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email"+studentDTO.getEmail()+"has been taken");
        }
        Student student = studentRespository.save(StudentConverter.convertToStudent(studentDTO));
        return student.getId();
    }
}
