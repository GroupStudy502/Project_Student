package org.choongang.student.controllers;

import org.choongang.global.*;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.ScoreMenu;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Score;
import org.choongang.student.entities.Student;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ScoresController extends AbstractController {
    @Override
    public void show() {

        Service<List<Score>> service = StudentServiceLocator.getInstance().find(StudentMenu.SCORES);
        List<Score> items = service.process();

        String scores = items == null ? "":items.stream().map(s -> String.format("학번:%d, 과목코드: %d, %d학년, %d학기, 성적: %d%n", s.getSNo(), s.getSubCode(), s.getSYear(), s.getSSem(), s.getSScore())).collect(Collectors.joining("\n"));

        //Templates.getInstance().render(StudentMenu.SCORES, () -> scores);

    }

    @Override
    public void prompt() {
        Gettable<Long, Score> service = (Gettable<Long, Score>) StudentServiceLocator.getInstance().find(StudentMenu.SCORES);

        while(true) {
            String studentNo = promptWithValidation("학번 입력: ", s -> !s.isBlank());
            try {
                long sNo = Long.parseLong(studentNo);

                List<Score> scores = (List<Score>)service.get(sNo);
                if (scores == null || scores.isEmpty() ) {

                    System.err.println("조회된 성적이 없습니다");
                    continue;
                }

                for (Score score : scores) {
                    System.out.printf("학번: %d%n", score.getSNo());
                    System.out.printf("1. 과목코드: %s%n", score.getSubCode());
                    System.out.printf("2. 학년: %d%n", score.getSYear());
                    System.out.printf("3. 학기: %s%n", score.getSSem());
                    System.out.printf("4. 성적: %s%n", score.getSScore());
                    System.out.println(Templates.getInstance().line());


                    System.out.print("수정(1), 삭제(2):");

                    String menuNo = sc.nextLine();
                    try {
                        int m = Integer.parseInt(menuNo);
                        process(m, score);
                        MainRouter.getInstance().change(MainMenu.STUDENT);
                        break;
                    } catch (Exception e) {
                        System.err.println("1, 2번 메뉴만 선택하세요.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("\n학번은 숫자로 입력하세요.");
            }

        }


    /*
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
                System.err.println("메뉴 1,2,3,4 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo) {
        ControllerLocator locator = ScoresControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo) {
            case 1: controller = locator.find(ScoreMenu.REG); break;
            case 2: controller = locator.find(ScoreMenu.EDIT); break;
            case 3: controller = locator.find(ScoreMenu.REMOVE); break;
            case 4: controller = locator.find(ScoreMenu.STATISIC); break;
            default:
                MainRouter.getInstance().change(MainMenu.MAIN);
                return;

        }
        if (controller != null) {
            controller.run();
        }
    }
    */
    }

    private void process(int menuNo, Score score) {
        ServiceLocator locator = StudentServiceLocator.getInstance();
        if (menuNo == 2) {
            Service<Long> service = locator.find(StudentMenu.SCOREDELETE);
            service.process(score.getSNo());
        } else {
            String itemNo = promptWithValidation("수정항목 번호 입력: ", s -> !s.isBlank());
            try {
                int no = Integer.parseInt(itemNo);
                if (no < 1 || no > 5 ) {
                    throw new RuntimeException();
                }

                String changeStr = promptWithValidation("변경 내용 입력: ", s -> !s.isBlank());

                Score form = Score.builder().sNo(score.getSNo()).build();

                switch (no) {
                    case 1: form.setSubCode(Long.parseLong(changeStr)); break;
                    case 2: form.setSYear(Long.parseLong(changeStr)); break;
                    case 3: form.setSSem(Long.parseLong(changeStr)); break;
                    case 4: form.setSScore(Long.parseLong(changeStr)); break;
                }

            } catch (Exception e) {
                System.err.println("\n1~5번 항목을 선택하세요.");
            }

            Service<Score> service = locator.find(StudentMenu.SCORESAVE);
            service.process(score);

        }
    }
}
