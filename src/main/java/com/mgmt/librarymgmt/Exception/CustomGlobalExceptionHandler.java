package com.mgmt.librarymgmt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public void userNotFoundExceptionHandle(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public void bookNotFoundExceptionHandle(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
    }

}
