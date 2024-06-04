package org.choongang.student.services;

import org.choongang.global.Service;
import org.choongang.student.entities.Student;
import org.choongang.student.mapper.StudentMapper;

public class StudentSaveService implements Service<Student>  {

    private StudentMapper mapper;

    public StudentSaveService(StudentMapper mapper) {
        this.mapper = mapper;
    }
    //테스트
    @Override
    public void process(Student form) {
        long sNo = form.getSNo();

        if (mapper.exist(sNo) > 0) { // 수정
            mapper.modify(form);
        } else {
            mapper.register(form);
        }
    }
}