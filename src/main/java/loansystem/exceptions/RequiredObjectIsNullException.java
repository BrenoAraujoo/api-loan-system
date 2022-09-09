package loansystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException{

    public RequiredObjectIsNullException() {
        super("Its not allowed to persist a null oject");
    }
    public RequiredObjectIsNullException(String message) {
        super("Its not allowed to persist a null oject");
    }
}
