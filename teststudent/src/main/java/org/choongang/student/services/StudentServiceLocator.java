package org.choongang.student.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.mapper.ScoreMapper;
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

    public ScoreMapper scoreMapper() {
        return DBConn.getSession().getMapper(ScoreMapper.class);
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

                case SCORES: service = new ScoreServiceList(scoreMapper()); break;
                case SCORESAVE: service = new ScoreSaveService(scoreMapper()); break;
                case SCOREDELETE: service = new ScoreDeleteService(scoreMapper()); break;
            }

        } else { // 주메뉴

        }

        //services.put(menu, service);

        return service;
    }
    public Service findUpdate(Menu menu) {
        //System.out.println("**StudentServiceLocator-findUpdate(" + menu + ")");
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
                case SUBJECTS: service = new SubjectServiceUpdate(SubjectMapper()); break;
                case STUDENTS:
                case SCORES: service = new SubjectServiceUpdate(SubjectMapper()); break;
            }

        } else { // 주메뉴

        }

        //services.put(menu, service);

        return service;
    }


}