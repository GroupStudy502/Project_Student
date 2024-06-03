package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.services.StudentServiceLocator;

public class SubjectsDeleteController extends AbstractController {
    @Override
    public void show() {
        System.out.println("**SubjectsDeleteController-show()");
    }
    @Override
    public void prompt() {
        System.out.println("\n삭제할 과목 코드를 입력하세요");
        
        int subCode = Integer.parseInt(promptWithValidation("과목코드: ", s -> !s.isBlank()));

        RequestSubject form = RequestSubject.builder()
                .subCode(subCode)
                .build();
        try {

            Service  service = StudentServiceLocator.getInstance().findDelete(StudentMenu.SUBJECTS);
            service.process(form);

        } catch (RuntimeException e) {

            System.err.println(e.getMessage());
        }
        MainRouter.getInstance().change(MainMenu.STUDENT);

    }

}
