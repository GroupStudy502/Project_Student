package org.choongang.template.student;


import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StudentTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("학생관리 메뉴 선택\n")
                .append(Templates.getInstance().line())
                .append("1. 과목\n")
                .append("2. 학생\n")
                .append("3. 성적\n")
                .append("4. 메인메뉴 이동\n");

        return sb.toString();
    }

}