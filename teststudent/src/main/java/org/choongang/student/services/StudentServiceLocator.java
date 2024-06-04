package org.choongang.student.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.mapper.SubjectMapper;

public class StudentServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new StudentServiceLocator();
        }

        return instance;
    }

    public SubjectMapper SubjectMapper() {
        return DBConn.getSession().getMapper(SubjectMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }

        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SubjectServiceList(SubjectMapper()); break;
                case STUDENTS:
                case SCORES:

            }

        } else { // 주메뉴

        }

        //services.put(menu, service);///이건 .. DB 업데이트 안되므로 쓰지말기

        return service;
    }
    public Service findUpdate(Menu menu) {

        Service service = null;
        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SubjectServiceUpdate(SubjectMapper()); break;
                case STUDENTS:
                case SCORES:
            }

        } else { // 주메뉴

        }
        return service;
    }
    public Service findInsert(Menu menu) {

        Service service = null;
        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SubjectServiceInsert(SubjectMapper()); break;
                case STUDENTS:
                case SCORES:
            }

        } else { // 주메뉴

        }
        return service;
    }
    public Service findDelete(Menu menu) {

        Service service = null;
        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SubjectServiceDelete(SubjectMapper()); break;
                case STUDENTS:
                case SCORES:
            }

        } else { // 주메뉴

        }
        return service;
    }

}