package org.choongang.student.services;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.global.exceptions.ValidationException;
import org.choongang.student.controllers.RequestSubject;
import org.choongang.student.entities.Subject;
import org.choongang.student.mapper.SubjectMapper;

@RequiredArgsConstructor
public class SubjectServiceUpdate implements Service<RequestSubject> {
    private final SubjectMapper mapper;

    @Override
    public void process( RequestSubject form) {
        System.out.println("**SubjectServiceUpdate-process()");
        // 과목 입력 유효성 검사
        //validator.check(form);

        // 데이터베이스에 영구 저장
        Subject subject = Subject.builder()
                .subCode(form.getSubCode())
                .subNm(form.getSubNm())
                .teacherNm(form.getTeacherNm())
                .subDiv(form.getSubDiv())
                .build();
        System.out.println("***subject=" + subject);
        int affectedRows = mapper.modify(subject);
        System.out.println("과목수정 affectedRows : " + affectedRows);
        if (affectedRows < 1) { // 과목 처리 실패시
            throw new ValidationException("과목 수정 실패하였습니다.");
        }

    }
}
