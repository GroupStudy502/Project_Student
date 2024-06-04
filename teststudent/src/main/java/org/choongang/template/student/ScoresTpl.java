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
        sb.append("성적정보 관리\n");
        sb.append(Templates.getInstance().line());
        if (hook != null) {
            sb.append(hook.get());
            sb.append(Templates.getInstance().line());
            sb.append("(1) 성적 등록 ");
            sb.append("(2) 성적 수정 ");
            sb.append("(3) 성적 삭제\n");
            sb.append("(4) 성적 통계 조회\n");

        }

        return sb.toString();
    }
}