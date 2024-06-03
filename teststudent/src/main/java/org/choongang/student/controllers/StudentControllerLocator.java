package org.choongang.student.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.student.constants.StudentMenu;

public class StudentControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private StudentControllerLocator() {}

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new StudentControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        System.out.println("**StudentControllerLocator-find(" + menu + ")");
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        // 학생서브 메뉴
        if (menu instanceof StudentMenu) {
            StudentMenu studentMenu = (StudentMenu) menu;
            switch(studentMenu) {
                case SUBJECTS: controller = new StudentController.SubjectsController(); break;
                case STUDENTS: controller = new StudentsController(); break;
                case SCORES: controller = new ScoresController(); break;
            }
        } else { // 학생 메인 메뉴
            controller = new StudentController();
        }


        return controller;
    }
}
