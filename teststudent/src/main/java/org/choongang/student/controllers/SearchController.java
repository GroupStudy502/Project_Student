package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.member.controllers.RequestLogin;

public class SearchController extends AbstractController {


    @Override
    public void prompt() { //조회할려는 학생의 학번 입력
        System.out.println("조회하려는 학번을 입력하세요.");
        String userNo = promptWithValidation("아이디: ", sNo -> !sNo.isBlank());
        RequestLogin form = RequestLogin.builder()
                .userId(userNo)
                .build();  //학번 입력 후 문제가 없을 경우
        //다음으로 추가, 삭제, 수정할 건지.



    }

    @Override
    public void show() {

    }
}
