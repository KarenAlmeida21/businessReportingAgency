package com.api.businessReportingAgency.componentes;

import com.api.businessReportingAgency.exceptions.ReportNotFound;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;


@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)

    public List<ErrorMessage> validationErrors(MethodArgumentNotValidException exception) {
        List<ErrorMessage> error = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            ErrorMessage errorMessage = new ErrorMessage(fieldError.getDefaultMessage());
            error.add(errorMessage);
        }

        return error;
    }

    @ExceptionHandler(ReportNotFound.class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    public ErrorMessage errorMessage(ReportNotFound exception) {
        return new ErrorMessage((exception.getMessage()));
    }


}
