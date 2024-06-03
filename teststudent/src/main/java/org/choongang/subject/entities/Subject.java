package org.choongang.subject.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subject {
    private long subCode;
    private String subNm;
    private String teacherNm;
    private String subDiv;
}