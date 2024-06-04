package org.choongang.template.score;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class RegTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("성적정보 등록\n");
        sb.append(Templates.getInstance().line());
        sb.append("\n");

        return sb.toString();
    }
}
