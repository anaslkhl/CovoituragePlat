
package com.app.covoiturage.advice;

import com.app.covoiturage.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ProblemDetail buildProblemDetail(
            HttpStatus status,
            String detail,
            String type,
            HttpServletRequest request
    ) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                status,
                detail
        );

        problem.setType(URI.create("urn:problem:" + type));
        problem.setTitle(status.getReasonPhrase());
        problem.setProperty("timestamp", OffsetDateTime.now());
        problem.setProperty("path", request.getRequestURI());

        return problem;
    }

    // 400 - Bean Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleValidation(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ) {
        String detail = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ProblemDetail problem = buildProblemDetail(
                HttpStatus.BAD_REQUEST,
                detail,
                "validation-error",
                request
        );

        return ResponseEntity.badRequest().body(problem);
    }

    // 400 - Constraint violations
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ProblemDetail> handleConstraintViolation(
            ConstraintViolationException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problem = buildProblemDetail(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                "constraint-violation",
                request
        );

        return ResponseEntity.badRequest().body(problem);
    }

    // 400 - Invalid JSON request
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handleInvalidJson(
            HttpMessageNotReadableException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problem = buildProblemDetail(
                HttpStatus.BAD_REQUEST,
                "The request body is invalid or malformed.",
                "invalid-request-body",
                request
        );

        return ResponseEntity.badRequest().body(problem);
    }


    // 404 - Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleResourceNotFound(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problem = buildProblemDetail(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                "resource-not-found",
                request
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleUnexpectedException(
            Exception exception,
            HttpServletRequest request
    ) {
        ProblemDetail problem = buildProblemDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected internal server error occurred.",
                "internal-server-error",
                request
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(problem);
    }
}
