package org.choongang.student.services;

import org.choongang.global.Listable;
import org.choongang.global.Service;
import org.choongang.global.Updatable;
import org.choongang.student.entities.Subject;
import org.choongang.student.mapper.SubjectMapper;

import java.util.List;

public class SubjectService implements Service<Subject>, Updatable<Subject>, Listable<Object, Subject> {

    private SubjectMapper mapper;

    public SubjectService(SubjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int update(Subject form) {
        return 0;
    }

    @Override
    public List<Subject> getList(Object search) {
        return Listable.super.getList(search);
    }
}
