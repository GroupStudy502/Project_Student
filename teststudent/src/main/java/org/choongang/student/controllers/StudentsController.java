package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Gettable;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Student;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentsController extends AbstractController {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    @Override
    public void prompt() {
        Gettable<Long, Student> service = (Gettable<Long, Student>) StudentServiceLocator.getInstance().find(StudentMenu.STUDENTS);

        while(true) {
            String studentNo = promptWithValidation("학번: ", s -> !s.isBlank());
            try {
                long sNo = Long.parseLong(studentNo);
                Student student = service.get(sNo);
                if (student == null) {
                    System.err.println("조회된 학생이 없습니다.");
                    continue;
                }

                System.out.printf("학번: %d%n", student.getSNo());
                System.out.printf("1. 이름: %s%n", student.getSNm());
                System.out.printf("2. 학년: %d%n", student.getSGrade());
                System.out.printf("3. 성별: %s%n", student.getSGen().equals("F") ? "여성":"남성");
                System.out.printf("4. 입학일: %s%n", formatter.format(student.getSAdmDt()));
                System.out.printf("5. 재적상태: %s%n", student.getSStat());
                System.out.println(Templates.getInstance().line());

                System.out.print("수정(1), 삭제(2):");

                String menuNo = sc.nextLine(); //1번인지 2번인지
                try {
                    int m = Integer.parseInt(menuNo);
                    process(m, student);
                    MainRouter.getInstance().change(MainMenu.STUDENT);
                    break;
                } catch (Exception e) {
                    System.err.println("1, 2번 메뉴만 선택하세요.");
                }


            } catch (Exception e) {
                System.err.println("\n학번은 숫자로 입력하세요.");
            }
        }
    }

    private void process(int menuNo, Student student) {
        ServiceLocator locator = StudentServiceLocator.getInstance();
        if (menuNo == 2) { // 삭제
            Service<Long> service = locator.find(StudentMenu.DELETE);
            service.process(student.getSNo());
        } else { // 수정

            String itemNo = promptWithValidation("수정항목 번호 입력: ", s -> !s.isBlank());
            try {
                int no = Integer.parseInt(itemNo);
                if (no < 1 || no > 5) {
                    throw new RuntimeException();
                }

                String changeStr = promptWithValidation("변경 내용 입력: ", s -> !s.isBlank());

                Student form = Student.builder()
                        .sNo(student.getSNo()).build();


                switch (no) {
                    case 1: form.setSNm(changeStr); break;
                    case 2: form.setSGrade(Long.parseLong(changeStr)); break;
                    case 3: form.setSGen(changeStr); break;
                    case 4: form.setSAdmDt(LocalDateTime.parse(changeStr, formatter)); break;
                    case 5: form.setSStat(changeStr); break;
                }

            } catch (Exception e) {
                System.err.println("\n1~5번 항목을 선택하세요.");
            }


            Service<Student> service = locator.find(StudentMenu.SAVE);
            service.process(student);
        }

    }


    @Override
    public void show() {
        Templates.getInstance().render(StudentMenu.STUDENTS);


    }
}
