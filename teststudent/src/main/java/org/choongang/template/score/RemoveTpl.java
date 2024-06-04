package org.choongang.template.score;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class RemoveTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("성적정보 삭제\n");
        sb.append(Templates.getInstance().line());
        sb.append("\n");

        return sb.toString();
    }
}
