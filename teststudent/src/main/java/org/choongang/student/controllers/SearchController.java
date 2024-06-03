package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.member.controllers.RequestLogin;

import java.util.Scanner;

public class SearchController extends AbstractController {


    @Override
    public void prompt() { //조회할려는 학생의 학번 입력
        System.out.println("조회하려는 학생의 학번을 입력하세요.");
        //조회하려는 학번을 입력한다.
        String studentNo = promptWithValidation("학번: ", sNo -> !sNo.isBlank());
        //학번을 공간에 담는다.
        RequestStundetNo form = RequestStundetNo.builder()
                .studentNo(Long.parseLong(studentNo))
                .build();

        //학번 입력 후 문제가 없을 경우, 다음으로 [추가, 삭제, 수정]선택
        System.out.print("1.추가 2.수정 3.삭제 원하시는 항목을 골라주세요");
        String menuNo = promptWithValidation("메뉴: ", sNo -> !sNo.isBlank());
        RequestMenuNo form = RequestMenuNo.builder()
                .menuNo(Long.parseLong(menuNo))
                .build();


        @Override
        public void show () {

        }
    }
}
