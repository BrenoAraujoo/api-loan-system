package loansystem.exceptions.handler;

import loansystem.exceptions.ResourceNotFoundException;
import loansystem.exceptions.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(Exception.class)
public final ResponseEntity<StandardException> handleAllExceptions(Exception ex, WebRequest request){

    StandardException err = new StandardException();
    err.setTimestamp(Instant.now());
    err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    err.setMessage(ex.getMessage());
    err.setError("Resource not found");
    err.setPath(request.getDescription(false));

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
}

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<StandardException> handleEntityNotFoundException(Exception ex, WebRequest request){

        StandardException err = new StandardException();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setError("Resource not found");
        err.setPath(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
