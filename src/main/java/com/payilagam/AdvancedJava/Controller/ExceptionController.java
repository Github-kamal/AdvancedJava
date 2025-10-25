package com.payilagam.AdvancedJava.Controller;


import com.payilagam.AdvancedJava.Pojo.ErrorExc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(PayilagamException.class)
    public ResponseEntity hand(PayilagamException ex) {
        System.err.println("An payilagam exception occurred: " + ex.getMessage());

        ErrorExc error = new ErrorExc(ex.getMessage(), System.currentTimeMillis(), 400);
        return ResponseEntity.status(400).body(error);


    }
}
