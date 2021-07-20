package lk.my.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
public class BindingErrorsResponse {

    public  static ResponseEntity<?> errorFields(List<FieldError> fieldErrors){

        Map<String ,String> map =  new HashMap<>();
        for (FieldError e: fieldErrors) {
            map.put(e.getField(),e.getDefaultMessage()) ;
        }
        return new ResponseEntity (map, HttpStatus.BAD_REQUEST);
    }
}
