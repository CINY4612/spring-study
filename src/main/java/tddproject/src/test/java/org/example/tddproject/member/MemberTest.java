package org.example.tddproject.member;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class MemberTest {
    @Autowired
    private Validator validator;

    @Test
    @DisplayName("멤버 객체 생성 확인")
    void createMember() {
        // Given
        String userId = "test@test.com";
        String password = "passwordTest";
        String nickname = "test_nickname";

        // when
        Member member = Member.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .build();

        // then
        assertThat(member.getUserId()).isEqualTo(userId);
        assertThat(member.getPassword()).isEqualTo(password);
        assertThat(member.getNickname()).isEqualTo(nickname);
    }

    @Test
    @DisplayName("userId Null 오류 체크")
    void createMemberWithNullUserId() {
        // Given
        String password = "passwordTest";
        String nickname = "test_nickname";

        // When
        Member member = Member.builder()
                .userId(null)
                .password(password)
                .nickname(nickname)
                .build();

        // Then
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        assertFalse(violations.isEmpty());

        ConstraintViolation<Member> violation = violations.iterator().next();
        assertEquals("공백일 수 없습니다", violation.getMessage());
        assertEquals("userId", violation.getPropertyPath().toString());
    }

    @Test
    @DisplayName("userId Email 오류 체크")
    void createMemberWithNonEmailUserId() {
        // Given
        String userId = "test";
        String password = "passwordTest";
        String nickname = "test_nickname";

        // When
        Member member = Member.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .build();

        // Then
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        assertFalse(violations.isEmpty());

        ConstraintViolation<Member> violation = violations.iterator().next();
        assertEquals("올바른 형식의 이메일 주소여야 합니다", violation.getMessage());
        assertEquals("userId", violation.getPropertyPath().toString());
    }

    @Test
    @DisplayName("password Null 오류 체크")
    void createMemberWithNullPassword() {
        // Given
        String userId = "test@test.com";
        String nickname = "test_nickname";

        // When
        Member member = Member.builder()
                .userId(userId)
                .password(null)
                .nickname(nickname)
                .build();

        // Then
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        assertFalse(violations.isEmpty());

        ConstraintViolation<Member> violation = violations.iterator().next();
        assertEquals("공백일 수 없습니다", violation.getMessage());
        assertEquals("password", violation.getPropertyPath().toString());
    }

    @Test
    @DisplayName("nickname Null 오류 체크")
    void createMemberWithNullNickname() {
        // Given
        String userId = "test@test.com";
        String password = "passwordTest";

        // When
        Member member = Member.builder()
                .userId(userId)
                .password(password)
                .nickname(null)
                .build();

        // Then
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        assertFalse(violations.isEmpty());

        ConstraintViolation<Member> violation = violations.iterator().next();
        assertEquals("공백일 수 없습니다", violation.getMessage());
        assertEquals("nickname", violation.getPropertyPath().toString());
    }

    @Test
    @DisplayName("nickname Null 오류 체크")
    void createMemberWithTooShortNickname() {
        // Given
        String userId = "test@test.com";
        String password = "passwordTest";
        String nickname = "1";

        // When
        Member member = Member.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .build();

        // Then
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        assertFalse(violations.isEmpty());

        ConstraintViolation<Member> violation = violations.iterator().next();
        assertEquals("길이가 3에서 255 사이여야 합니다", violation.getMessage());
        assertEquals("nickname", violation.getPropertyPath().toString());
    }
}