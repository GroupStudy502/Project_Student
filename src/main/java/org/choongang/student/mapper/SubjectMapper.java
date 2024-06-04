package org.choongang.student.mapper;
import org.choongang.student.entities.Subject;

import java.util.List;

public interface SubjectMapper {

    List<Subject> getSubject();
    Subject get(long subCode);
    int modify(Subject subject);

}