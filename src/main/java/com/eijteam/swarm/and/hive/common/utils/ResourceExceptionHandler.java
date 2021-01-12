package com.eijteam.swarm.and.hive.common.utils;

import com.eijteam.swarm.and.hive.common.DTOs.StandardErrorDTO;
import com.eijteam.swarm.and.hive.common.exceptions.UnauthorizedException;
import com.eijteam.swarm.and.hive.common.exceptions.ForbiddenException;
import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.modules.user.exceptions.AlreadyRegisteredUserException;
import com.eijteam.swarm.and.hive.modules.user.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorDTO> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorDTO err = new StandardErrorDTO(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardErrorDTO> userNotFound(UserNotFoundException e, HttpServletRequest request){
        String error = "User not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorDTO err = new StandardErrorDTO(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AlreadyRegisteredUserException.class)
    public ResponseEntity<StandardErrorDTO> alreadyRegisteredUser(AlreadyRegisteredUserException e, HttpServletRequest request){
        String error = "User already registered";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardErrorDTO err = new StandardErrorDTO(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<StandardErrorDTO> forbidden(ForbiddenException e, HttpServletRequest request){
        String error = "Forbidden";
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardErrorDTO err = new StandardErrorDTO(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardErrorDTO> authentication(UnauthorizedException e, HttpServletRequest request){
        String error = "Unauthorized";
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardErrorDTO err = new StandardErrorDTO(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
