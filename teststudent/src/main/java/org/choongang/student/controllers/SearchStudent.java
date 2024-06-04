package org.choongang.student.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchStudent {
    private long sNo; //학번
    private String sNm; //이름
    private long sGrade; //학년
    private String sGen; // 성별
    private String keyword; //데이터베이스 검색 시 필요한...?
    private LocalDateTime sAdmDt; // 입학일
    private String sStat; // 재적상태
}