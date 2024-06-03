package org.choongang.subject.services;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.student.mapper.SubjectMapper;

import java.util.List;

@RequiredArgsConstructor
public class SubjectServiceList implements Service<List<Subject>> {
    private final SubjectMapper mapper;

    @Override
    public List<Subject> process() {
        System.out.println("**SubjectService-process1()");
        return mapper.getSubject();

    }
}
