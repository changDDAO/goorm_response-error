package com.changddao.goorm_response_error.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotNull(message = "client가 username을 입력하지 않았습니다.")
    private String username;
    @Max(value = 5, message = "5를 초과하는 학점은 입력이 불가능 합니다.")
    private Integer grade;

    @Builder
    public User(String username, Integer grade) {
        this.username = username;
        this.grade = grade;
    }

    //이름 변경 메서드
    public void changeUsername(String name) {
        this.username = name;
    }
    //학점 변경 메서드
    public void changeGrade(Integer grade) {
        this.grade = grade;
    }
}
