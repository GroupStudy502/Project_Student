package org.choongang.student.services;

import org.choongang.global.Service;
import org.choongang.student.mapper.StudentMapper;

public class StudentDeleteService implements Service<Long>  {
    private StudentMapper mapper;
    public StudentDeleteService(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Long sNo) {
        mapper.delete(sNo);
    }
}
