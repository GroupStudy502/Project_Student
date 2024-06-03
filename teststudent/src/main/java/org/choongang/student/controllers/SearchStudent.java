package org.choongang.student.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchStudent {
    private long sNo;
    private String sNm;
    private long sGrade;
    private String sGen;
    private String keyword;
    private LocalDateTime sAdmDt;
    private String sStat;
}