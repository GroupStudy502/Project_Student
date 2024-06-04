package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.template.Templates;

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
                System.err.println("메뉴 1,2,3,4 중에서 선택하세요.");
            }
        }
    }
    public void change(int menuNo){
        ControllerLocator locator = StudentControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 1: controller = locator.find(StudentMenu.SUBJECTS); break;
            case 2: controller = locator.find(StudentMenu.STUDENTS); break;
            case 3: controller = locator.find(StudentMenu.SCORES); break;
            default:
                MainRouter.getInstance().change(MainMenu.MAIN);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
