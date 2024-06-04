package org.choongang.main;

import org.choongang.game.controllers.GameControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.Startable;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;
import org.choongang.student.controllers.StudentControllerLocator;

public class MainRouter implements Router, Startable {

    private static MainRouter instance;

    private MainRouter() {}

    public static MainRouter getInstance() {
        if (instance == null) {
            instance = new MainRouter();
        }

        return instance;
    }

    @Override
    public void change(MainMenu mainMenu) {
        //System.out.println("MainRouter-change(" + mainMenu + ")");
        ControllerLocator memlocator = MemberControllerLocator.getInstance();
        ControllerLocator gamelocator = GameControllerLocator.getInstance();
        ControllerLocator studentlocator = StudentControllerLocator.getInstance();

        Controller controller = null;
        switch(mainMenu) {
            case JOIN: controller =  memlocator.find(MainMenu.JOIN); break;
            case LOGIN: controller = memlocator.find(MainMenu.LOGIN); break;
            case GAME: controller = gamelocator.find(MainMenu.GAME); break;
            case STUDENT: controller = studentlocator.find(MainMenu.STUDENT); break;
            default: controller = new MainController();
        }

        controller.run(); // common(), show(), prompt()
    }

    @Override
    public void start() {
        while(true) {
            change(MainMenu.MAIN); // 첫 화면은 메인 컨트롤러 출력 화면
        }
    }
}
