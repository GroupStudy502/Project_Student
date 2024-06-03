package org.choongang.student.mapper;

import org.choongang.student.controllers.SearchStudent;
import org.choongang.student.entities.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getList(SearchStudent search);
    Student get(long sNo);
    int exist(long sNo);
    int register(Student student);
    int modify(Student student);
    int delete(long sNo);
}
