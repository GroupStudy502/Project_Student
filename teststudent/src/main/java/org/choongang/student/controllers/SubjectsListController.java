package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Subject;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectsListController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(StudentMenu.SUBJECTS);
    }
    @Override
    public void prompt() {
        Service<List<Subject>> service = StudentServiceLocator.getInstance().find(StudentMenu.SUBJECTS);
        List<Subject> subjects = service.process();
        String subjecting = subjects.stream()
                .map(r -> String.format("%d %s %s %s", r.getSubCode(), r.getSubNm(), r.getTeacherNm(), r.getSubDiv()))
                .collect(Collectors.joining("\n"));

        Templates.getInstance().render(StudentMenu.SUBJECTS, () -> subjecting);

        System.out.println("\n과목정보 작업을 고르세요");
        int no = Integer.parseInt(promptWithValidation("추가(1) 수정(2) 삭제(3) 상위메뉴(4) : ", s -> !s.isBlank()));
        ControllerLocator studentlocator = StudentControllerLocator.getInstance();
        Controller controller = null;
        switch (no) {
            case 1:
                controller = studentlocator.find(StudentMenu.SUBINSERT);
                break;
            case 2:
                controller = studentlocator.find(StudentMenu.SUBUPDATE);
                break;
            case 3:
                controller = studentlocator.find(StudentMenu.SUBDELETE);
                break;
            default:
                controller = studentlocator.find(MainMenu.STUDENT);
        }

        controller.run();

        //MainRouter.getInstance().change(MainMenu.STUDENT);
    }

}
