package org.choongang.student.controllers;

import lombok.Builder;
import lombok.Data;
import org.choongang.global.AbstractController;
import org.choongang.global.Gettable;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Student;
import org.choongang.student.services.StudentServiceLocator;

@Data
@Builder
public class RequestMenuNo {
    private int menuNo;

    public static class SearchController extends AbstractController {

        @Override
        public void show() {

        }

        @Override
        public void prompt() {
            Gettable<Long, Student> service = (Gettable<Long, Student>) StudentServiceLocator.getInstance().find(StudentMenu.STUDENTS);

            while(true) {
                String studentNo = promptWithValidation("학번: ", s -> !s.isBlank());
                try {
                    long sNo = Long.parseLong(studentNo);
                    Student student = service.get(sNo);
                    System.out.println(student);
                } catch (Exception e) {
                    System.err.println("학번은 숫자로 입력하세요.");
                }
            }
        }
    }
}
