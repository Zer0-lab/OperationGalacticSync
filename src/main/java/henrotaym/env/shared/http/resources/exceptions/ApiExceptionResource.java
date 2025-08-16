package henrotaym.env.shared.http.resources.exceptions;

import henrotaym.env.shared.enums.exceptions.ExceptionType;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.http.HttpStatus;

public record ApiExceptionResource(
    String message,
    HttpStatus status,
    LocalDateTime timestamp,
    ExceptionType type,
    HashMap<String, ?> data) {}
