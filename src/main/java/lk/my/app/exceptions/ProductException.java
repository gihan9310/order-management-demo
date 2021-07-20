package lk.my.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductException extends RuntimeException {

    public ProductException(String message) {
        super(message);
    }
}
