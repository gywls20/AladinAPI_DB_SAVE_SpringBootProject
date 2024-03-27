package com.hyojin.Aladdin.controller;

import com.hyojin.Aladdin.service.BookService;
import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import com.hyojin.Aladdin.dto.BookDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping("/fetch-data")
    @Operation(hidden = true)
    public String fetchDataFromApi() {
        bookService.fetchDataFromApi();
        return "완료입니다.";
    }
}