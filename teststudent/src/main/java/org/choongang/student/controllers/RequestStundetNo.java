package org.choongang.student.controllers;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestStundetNo {
    private long studentNo;
}
