package org.choongang.student.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSubject {
    private long subCode;
    private String subNm;
}
