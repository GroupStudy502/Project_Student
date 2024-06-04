package org.choongang.student.constants;

import org.choongang.global.Menu;

public enum StudentMenu implements Menu {
    SUBJECTS, // 과목
    STUDENTS, // 학생
    SCORES, // 성적

    SUBINSERT, //과목추가
    SUBUPDATE, //과목수정
    SUBDELETE, //과목삭제

    SAVE, //저장
    DELETE// 삭제
}