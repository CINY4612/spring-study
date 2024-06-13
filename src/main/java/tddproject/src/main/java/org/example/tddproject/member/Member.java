package org.example.tddproject.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.tddproject.global.Timestamp;
import org.hibernate.validator.constraints.Length;

@Getter
@Entity(name = "member")
@NoArgsConstructor
public class Member extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(name = "user_id", nullable = false)
    private String userId;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank
    @Length(min = 3, max = 255)
    @Column(name = "nickname", nullable = false)
    private String nickname;

    /**
     * 멤버 객체를 생성한다
     *
     * @param userId   email 형식의 id
     * @param password password
     * @param nickname 3~255자 이내의 닉네임을 입력한다.
     */
    @Builder
    public Member(@Email String userId,
                  String password,
                  @Length(min = 3, max = 255) String nickname) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }
}

