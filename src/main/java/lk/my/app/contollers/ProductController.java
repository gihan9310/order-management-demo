package lk.my.app.contollers;

import lk.my.app.models.ProductDTO;
import lk.my.app.services.ProductService;
import lk.my.app.utils.BindingErrorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO product, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
           return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }

        ProductDTO dto = productService.save(product);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody ProductDTO product, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }

        ProductDTO dto = productService.update(product);
        return new ResponseEntity(dto, HttpStatus.OK);
    }


    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        List<ProductDTO> list = productService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping(value = "/findBy/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        ProductDTO dto = productService.findById(id);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteBy/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Long deleteId = productService.delete(id);
        return new ResponseEntity(deleteId, HttpStatus.OK);
    }
}
