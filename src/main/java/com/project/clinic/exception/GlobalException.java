package com.project.clinic.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    private static Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFound(DoctorNotFoundException e,HttpServletRequest req){
        logger.warn("Doctor Not Found {} | PathVariable {}",e.getMessage(),req.getRequestURI());
        ErrorResponse error = new ErrorResponse("Not Found",404, LocalDateTime.now(), e.getMessage(), req.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundException e,HttpServletRequest req){
        logger.warn("Patient Not Found {} | PathVariable {}",e.getMessage(),req.getRequestURI());
        ErrorResponse error = new ErrorResponse("Not found", 404, LocalDateTime.now(), e.getMessage(), req.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentNotFound(AppointmentNotFoundException e ,HttpServletRequest req){
        logger.warn("Patient Not Found {} | PathVariable {}",e.getMessage(),req.getRequestURI());
        ErrorResponse error = new ErrorResponse("Not found", 404, LocalDateTime.now(), e.getMessage(), req.getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
