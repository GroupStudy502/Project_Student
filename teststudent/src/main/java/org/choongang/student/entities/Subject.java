package org.choongang.student.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Subject {
    private long subCode;
    private String subNm;
    private String teacherNm;
    private String subDiv;
}