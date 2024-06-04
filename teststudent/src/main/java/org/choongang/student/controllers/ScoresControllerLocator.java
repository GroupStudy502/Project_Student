package org.choongang.student.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.student.constants.ScoreMenu;
import org.choongang.student.controllers.score.EditController;

public class ScoresControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private ScoresControllerLocator() {}

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new ScoresControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        if (menu instanceof ScoreMenu){
            ScoreMenu scoreMenu = (ScoreMenu) menu;
            switch (scoreMenu) {
                case REG : controller = new EditController();
                case EDIT: controller = new ScoresController(); break;
                case REMOVE: controller = new ScoresController(); break;
                case STATISIC: controller = new ScoresController(); break;

            }
        } else {
            controller = new ScoresController();
        }

        return controller;
    }
}
