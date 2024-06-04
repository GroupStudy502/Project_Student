package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.template.Templates;

public class ScoresController extends AbstractController {
    @Override
    public void show() {
        System.out.println("*******************************");
        System.out.println("*******성적리스트 여기구현 *******");
        System.out.println("*******************************");
        /*
        Service<List<Subject>> service = SubjectServiceLocator.getInstance().find(StudentMenu.SUBJECTS);

        List<Subject> ranks = service.process();
        String ranking = ranks.stream()
                .map(r -> String.format("%d등 - %s(%s)/%d점", r.getRank(), r.getUserNm(), r.getUserId(), r.getTotal()))
                .collect(Collectors.joining("\n"));

        */
        Templates.getInstance().render(StudentMenu.SCORES);
        // 과목리스트 출력 후 학생관리 메뉴 이동
        MainRouter.getInstance().change(MainMenu.STUDENT);
    }
}
