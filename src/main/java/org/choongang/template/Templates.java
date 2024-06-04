package org.choongang.template;

import org.choongang.game.constants.GameMenu;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.student.constants.StudentMenu;
import org.choongang.template.game.GameTpl;
import org.choongang.template.game.RankTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.member.MypageTpl;
import org.choongang.template.student.ScoresTpl;
import org.choongang.template.student.StudentTpl;
import org.choongang.template.student.SubjectsTpl;
import org.choongang.template.student.StudentsTpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Templates {
    private static Templates instance;
    private Map<Menu, Template> tpls;

    private Templates() {
        tpls = new HashMap<>();
    }

    public static Templates getInstance() {
        if (instance == null) {
            instance = new Templates();
        }

        return instance;
    }

    public void render(Menu menu) {
        render(menu, null);
    }

    public void render(Menu menu, Supplier<String> hook) {
        System.out.println(find(menu, hook).getTpl());
    }

    public Template find(Menu menu, Supplier<String> hook) {
        Template tpl = tpls.get(menu);

        if (hook != null) {
            tpl.addHook(hook); // 이게 여기 와야 할듯
        }
        if (tpl != null) {
            return tpl;
        }


        if (menu instanceof GameMenu) {
            GameMenu gameMenu = (GameMenu) menu;
            switch(gameMenu) {
                case ALONE:
                case TOGETHER:
                case RANKING: tpl = new RankTpl(); break;
            }
        } else if (menu instanceof MainMenu) {
            MainMenu mainMenu = (MainMenu)menu;
            switch (mainMenu) {
                case JOIN:
                    tpl = new JoinTpl();
                    break;
                case LOGIN:
                    tpl = new LoginTpl();
                    break;
                case MYPAGE:
                    tpl = new MypageTpl();
                    break;
                case GAME:
                    tpl = new GameTpl();
                    break;
                case STUDENT:
                    tpl = new StudentTpl();
                    break;
                default:
                    tpl = new MainTpl();
            }
        } else if (menu instanceof StudentMenu) {
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS:
                    tpl = new SubjectsTpl();
                    break;
                case STUDENTS:
                    tpl = new StudentsTpl();
                    break;
                case SCORES:
                    tpl = new ScoresTpl();
                    break;
                default:
                    tpl = new MainTpl();
            }
        } else  {
            System.out.println("아직 미구현 메뉴별 템플릿");

        }
        if (hook != null) {
            tpl.addHook(hook);
        }

        tpls.put(menu, tpl);

        return tpl;
    }

    public String line() {
        return "-----------------------------------\n";
    }

    public String doubleLine() {
        return "===================================\n";
    }
}