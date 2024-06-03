package org.choongang.student.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Subject;
import org.choongang.student.mapper.StudentMapper;
import org.choongang.student.mapper.SubjectMapper;

import java.util.List;

public class StudentServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new StudentServiceLocator();
        }

        return instance;
    }

    public SubjectMapper subjectMapper() {
        return DBConn.getSession().getMapper(SubjectMapper.class);
    }
    public StudentMapper studentMapper() {
        return DBConn.getSession().getMapper(StudentMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        System.out.println("**StudentServiceLocator-find(" + menu + ")");
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }

        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SubjectServiceList(subjectMapper()); break;
                case STUDENTS: service = new StudentServiceList(studentMapper()); break;
                case SCORES: service = new SubjectServiceList(subjectMapper()); break;
                case SAVE: service = new StudentSaveService(studentMapper()); break;
                case DELETE: service = new StudentDeleteService(studentMapper()); break;
            }

        } else { // 주메뉴

        }

        //services.put(menu, service);

        return service;
    }
    public Service findUpdate(Menu menu) {
        System.out.println("**StudentServiceLocator-findUpdate(" + menu + ")");
        /*
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }
         */
        Service service = null;
        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SearchScore.SubjectServiceUpdate(subjectMapper()); break;
                case STUDENTS:
                case SCORES: service = new SearchScore.SubjectServiceUpdate(subjectMapper()); break;
            }

        } else { // 주메뉴

        }

        //services.put(menu, service);

        return service;
    }


    @RequiredArgsConstructor
    public static class SubjectServiceList implements Service<List<Subject>> {
        private final SubjectMapper mapper;

        @Override
        public List<Subject> process() {
            System.out.println("**SubjectService-process1()");
            return mapper.getSubject();

        }
    }
}