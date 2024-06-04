package org.choongang.template.student;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

public class SubjectsListTpl implements Template {

    private Supplier<String> hook;

    public void addHook(Supplier<String> hook) {

        this.hook = hook;
    }

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        if (hook != null) {
            sb.append("과목리스트\n");
            sb.append(Templates.getInstance().line());
            sb.append(hook.get());
        }
        return sb.toString();
    }
}