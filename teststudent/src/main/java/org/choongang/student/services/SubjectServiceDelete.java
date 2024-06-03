package org.choongang.student.services;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.global.exceptions.ValidationException;
import org.choongang.student.controllers.RequestSubject;
import org.choongang.student.entities.Subject;
import org.choongang.student.mapper.SubjectMapper;

@RequiredArgsConstructor
public class SubjectServiceDelete implements Service<RequestSubject> {
    private final SubjectMapper mapper;

    @Override
    public void process( RequestSubject form) {
        // 과목 입력 유효성 검사
        //validator.check(form);

        // 데이터베이스에 영구 저장
        Subject subject = Subject.builder()
                .subCode(form.getSubCode())
                .subNm(form.getSubNm())
                .teacherNm(form.getTeacherNm())
                .subDiv(form.getSubDiv())
                .build();
        int affectedRows = mapper.delete(subject);
        System.out.println("과목 " + affectedRows + "건이 삭제되었습니다.");
        if (affectedRows < 1) { // 과목 처리 실패시
            throw new ValidationException("과목 삭제 실패하였습니다.");
        }

    }
}
