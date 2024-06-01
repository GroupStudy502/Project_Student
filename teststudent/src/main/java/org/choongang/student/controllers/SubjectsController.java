package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Subject;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectsController extends AbstractController {
    @Override
    public void show() {
        System.out.println("SubjectsController-show()");
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

        // 과목리스트 출력 후 학생관리 메뉴 이동
        MainRouter.getInstance().change(MainMenu.STUDENT);
    }

}
