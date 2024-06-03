package org.choongang.subject.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.student.constants.StudentMenu;
import org.choongang.subject.RequestSubject;
import org.choongang.subject.entities.Subject;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectsController extends AbstractController {
    @Override
    public void show() {
        System.out.println("**SubjectsController-show()");
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
        System.out.println("수정이나 삭제할 과목?");
        
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


        // 과목리스트 출력 후 학생관리 메뉴 이동
        //MainRouter.getInstance().change(MainMenu.STUDENT);



        //Router router = MainRouter.getInstance();
        try {
            System.out.println("여기여기1");

            Service  service1 = StudentServiceLocator.getInstance().findUpdate(StudentMenu.SUBJECTS);
            service1.process(form);

            System.out.println("여기여기2");
            Templates.getInstance().render(StudentMenu.SUBJECTS);
            //router.change(StudentMenu.SUBJECTS); // 과목 수정 삭제 성공시 -> 과목관리페이지
        } catch (RuntimeException e) {

            System.err.println(e.getMessage());
            Templates.getInstance().render(StudentMenu.SUBJECTS);
            //router.change(MainMenu.LOGIN); // 로그인 실패시 -> 로그인 페이지
        }
    }

}
