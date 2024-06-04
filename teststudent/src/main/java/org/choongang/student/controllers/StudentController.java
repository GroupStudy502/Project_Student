package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.student.services.RequestSubject;
import org.choongang.student.entities.Subject;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class StudentController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.STUDENT);
    }

    @Override
    public void prompt() {

        while(true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 1 && m <= 4) {
                    change(m);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("메뉴 1,2,3,4번 중에서 선택하세요.");
            }
        }
    }
    public void change(int menuNo){
        //  System.out.println("**StudentController-change(" + menuNo + ")");

        Controller controller = null;

        ControllerLocator locator = StudentControllerLocator.getInstance();

        switch(menuNo) {
            case 1: controller = locator.find(StudentMenu.SUBJECTS); break;
            case 2: controller = locator.find(StudentMenu.STUDENTS); break;
            case 3: controller = locator.find(StudentMenu.SCORES); break;
            default:
                MainRouter.getInstance().change(MainMenu.MAIN);
                return;
        }

        if (controller != null) {
            controller.run();   // ??
        }
    }

    public static class SubjectsController extends AbstractController {
        @Override
        public void show() {
            //    System.out.println("**SubjectsController-show()");
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
                //  System.out.println("여기여기1");

                Service  service1 = StudentServiceLocator.getInstance().findUpdate(StudentMenu.SUBJECTS);
                service1.process(form);

                //     System.out.println("여기여기2");
                Templates.getInstance().render(StudentMenu.SUBJECTS);
                //router.change(StudentMenu.SUBJECTS); // 과목 수정 삭제 성공시 -> 과목관리페이지
            } catch (RuntimeException e) {

                System.err.println(e.getMessage());
                Templates.getInstance().render(StudentMenu.SUBJECTS);
                //router.change(MainMenu.LOGIN); // 로그인 실패시 -> 로그인 페이지
            }
        }

    }
}