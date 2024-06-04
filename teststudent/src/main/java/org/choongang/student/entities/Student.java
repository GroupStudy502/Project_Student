package org.choongang.student.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder

public class Student {
    private long sNo; //학번
    private String sNm; //이름
    private long sGrade; // 학년
    private String sGen; // 성별
    private LocalDateTime sAdmDt; //입학일
    private String sStat;// 재적상태
}