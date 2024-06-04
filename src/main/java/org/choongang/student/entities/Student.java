package org.choongang.student.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Student {
    private long sNo;
    private String sNm;
    private long sGrade;
    private String sGen;
    private LocalDateTime sAdmDt;
    private String sStat;
}