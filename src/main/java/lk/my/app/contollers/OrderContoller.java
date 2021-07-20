package lk.my.app.contollers;

import lk.my.app.models.OrderDTO;
import lk.my.app.services.OrderService;
import lk.my.app.utils.BindingErrorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@RestController
@RequestMapping(value = "/orders")
@CrossOrigin
public class OrderContoller {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody OrderDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }

        OrderDTO order =  orderService.save(dto);
        return new ResponseEntity(order, HttpStatus.OK);
    }
}
