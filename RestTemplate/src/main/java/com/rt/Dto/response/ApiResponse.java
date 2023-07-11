package com.rt.Dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
public class ApiResponse<T> {

    private T data;

    private Integer statusCode;

    private List<String> errors;
}
