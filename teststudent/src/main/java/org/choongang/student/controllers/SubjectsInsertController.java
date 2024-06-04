package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.services.StudentServiceLocator;

public class SubjectsInsertController extends AbstractController {
    @Override
    public void show() {
    }
    @Override
    public void prompt() {
        System.out.println("\n추가할 과목코드를 입력하세요");
        
        int subCode = Integer.parseInt(promptWithValidation("과목코드: ", s -> !s.isBlank()));
        String subNm = promptWithValidation("과목명: ", s -> !s.isBlank());
        String teacherNm = promptWithValidation("교사: ", s -> !s.isBlank());
        String subDiv = promptWithValidation("문이과구분(문/이): ", s -> !s.isBlank());

        RequestSubject form = RequestSubject.builder()
                .subCode(subCode)
                .subNm(subNm)
                .teacherNm(teacherNm)
                .subDiv(subDiv)
                .build();
        try {

            Service  service = StudentServiceLocator.getInstance().findInsert(StudentMenu.SUBJECTS);
            service.process(form);

        } catch (RuntimeException e) {

            System.err.println(e.getMessage());
        }
        MainRouter.getInstance().change(MainMenu.STUDENT);

    }

}
