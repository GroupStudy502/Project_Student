package org.choongang.template.student;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

public class ScoresTpl implements Template {

    private Supplier<String> hook;

    public void addHook(Supplier<String> hook) {
        this.hook = hook;
    }

    @Override
    public String getTpl() {

        StringBuffer sb = new StringBuffer(2000);
        sb.append("성적보기 템플릿 ScoresTpl\n");
        sb.append(Templates.getInstance().line());
        if (hook != null) {
            sb.append(hook.get());
        }

        return sb.toString();
    }
}