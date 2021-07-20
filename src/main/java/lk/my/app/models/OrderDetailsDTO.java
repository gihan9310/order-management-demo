package lk.my.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.my.app.entities.Order;
import lk.my.app.entities.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailsDTO {

    private Long id;
    private double price;
    private  double quantity;
    private double lineDiscountAmount;
    private double lineDiscountPer;
    private Long productId;

    @JsonIgnore
    public OrderDetails getEntity(){
        OrderDetails dto = new OrderDetails();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }

}
