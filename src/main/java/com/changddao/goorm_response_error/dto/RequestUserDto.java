package com.changddao.goorm_response_error.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RequestUserDto {
    @NotEmpty(message = "이름은 필수로 입력해야합니다.")
    private String username;
    @Min(value = 1, message = "학점이 1학점보다 낮을 수 없습니다.")
    @Max(value = 5, message = "학점은 5학점을 초과할 수 없습니다.")
    private Integer grade;

}
