package org.choongang.student.controllers.score;

import org.choongang.global.AbstractController;
import org.choongang.student.constants.ScoreMenu;
import org.choongang.template.Templates;

public class EditController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(ScoreMenu.EDIT);
    }
}
