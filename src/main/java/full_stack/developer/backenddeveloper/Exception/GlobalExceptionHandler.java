package full_stack.developer.backenddeveloper.Exception;

import full_stack.developer.backenddeveloper.DTO.Exception.ExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> HandleResourceNotFoundException(ResourceNotFoundException re,
                                                                        HttpServletRequest request) {
        ExceptionDTO exceptionResponse = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                re.getMessage(),
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionDTO> HandleDuplicateResourceException(DuplicateResourceException DE,
                                                                         HttpServletRequest request){
        ExceptionDTO exceptionResponse = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                DE.getMessage(),
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> HandleBadRequestException(BadRequestException bq,
                                                                  HttpServletRequest request){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                bq.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionDTO);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> HandleRuntimeException(RuntimeException re,
                                                                       HttpServletRequest request) {
        ExceptionDTO exceptionResponse = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                re.getMessage(),
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionDTO> HandleRuntimeException(AuthenticationException Au,
                                                               HttpServletRequest request){
        ExceptionDTO exceptionResponse = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                Au.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(exceptionResponse);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDTO> handleAccessDeniedException(
            AccessDeniedException ex,
            HttpServletRequest request) {

        ExceptionDTO exceptionResponse = new ExceptionDTO(
                LocalDateTime.now(),
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(exceptionResponse);
    }
}
