package org.choongang.scores;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchScore {
    private long seq;
    private String sNo;
    private String subCode;
    private long sYear;
    private long sSem;
    private long sScore;
}