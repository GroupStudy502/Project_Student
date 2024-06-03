package org.choongang.student.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Gettable;
import org.choongang.global.Listable;
import org.choongang.global.Service;
import org.choongang.student.controllers.SearchStudent;
import org.choongang.student.entities.Student;
import org.choongang.student.mapper.StudentMapper;

import java.util.List;

@RequiredArgsConstructor
public class StudentServiceList implements Service<List<Student>>, Listable<SearchStudent, Student>, Gettable<Long, Student> {
     private final StudentMapper mapper;

    @Override
    public List<Student> getList(SearchStudent search) {
        return mapper.getList(search);
    }

    @Override
    public Student get(Long data) {
        return mapper.get(data);
    }
}
