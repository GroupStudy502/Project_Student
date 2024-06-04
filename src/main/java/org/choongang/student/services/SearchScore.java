package org.choongang.student.services;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.student.mapper.SubjectMapper;

@Data
@Builder
public class SearchScore {
    private long seq;
    private String sNo;
    private String subCode;
    private long sYear;
    private long sSem;
    private long sScore;

    @RequiredArgsConstructor
    public static class SubjectServiceUpdate implements Service<RequestSubject> {
        private final SubjectMapper mapper;

        @Override
        public void process( RequestSubject form) {

        }
    }
}