package lk.my.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(ProductException exception , WebRequest request){
        ProductExceptionResponse response = new ProductExceptionResponse(exception.getMessage());
        return  new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
