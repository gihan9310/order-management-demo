package lk.my.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.my.app.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductDTO {

    private Long id;
    @NotBlank(message = "Product code is required.")
    @Size(min = 1 ,max = 30,message = "Product code characters length must be match( min 1 max 30)")
    private String productCode;
    @NotBlank(message = "Product description is required.")
    @Size(min = 1 ,max = 100,message = "Product description characters length must be match( min 1 max 30)")
    private String productDescription;

    private Long aviableQty;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    @JsonIgnore
    public Product getEntity(){
        Product dto = new Product();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
