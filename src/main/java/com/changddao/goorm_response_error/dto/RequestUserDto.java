package com.changddao.goorm_response_error.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestUserDto {
    @NotNull
    private String username;
    @Min(value = 1, message = "재수강ㄱ")
    @Max(value = 5, message = "학점은 5학점을 초과할 수 없습니다.")
    private Integer grade;


}
