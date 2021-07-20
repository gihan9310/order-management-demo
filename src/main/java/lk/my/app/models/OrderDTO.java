package lk.my.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.my.app.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {

    private Long id;
    private LocalDate orderDate;
    private String customerName;
    private String mobile;
    private Double totalDiscountPer=0d;
    private double totalDiscountValue;
    private double finalPaymentValue;
    private double balance;
    private double invoiceValue;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    @Valid
    private List<OrderDetailsDTO> orderDetails;

    @JsonIgnore
    public Order getEntity(){
        Order dto = new Order();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }



}
