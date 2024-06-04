package org.choongang.game.controllers;

import org.choongang.game.constants.GameMenu;
import org.choongang.game.play.controllers.PlayController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

public class GameControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private GameControllerLocator() {}

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new GameControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        // 게임 서브 메뉴
        if (menu instanceof GameMenu) {
            GameMenu gameMenu = (GameMenu) menu;
            switch(gameMenu) {
                case ALONE:
                case TOGETHER: controller = new PlayController(); break;
                case RANKING: controller = new RankingController(); break;
            }
        } else { // 게임 메인 메뉴
            controller = new GameController();
            //controller = new PlayController();
        }


        return controller;
    }
}