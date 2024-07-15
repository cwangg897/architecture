package com.example.hexa.common.controller;

import com.example.hexa.common.controller.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health-check")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<ApiResponse<String>> healthCheck(){
        return ResponseEntity.ok(ApiResponse.ok("헬스체크 OK"));
    }

}
