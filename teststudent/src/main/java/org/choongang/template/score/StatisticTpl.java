package org.choongang.template.score;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StatisticTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("성적정보 통계조회\n");
        sb.append(Templates.getInstance().line());
        sb.append("\n");

        return sb.toString();
    }
}
