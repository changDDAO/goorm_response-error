package com.changddao.goorm_response_error.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Results <T>{
    T data;
}
