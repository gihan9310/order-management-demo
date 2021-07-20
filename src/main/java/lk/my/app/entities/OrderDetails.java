package lk.my.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.my.app.models.OrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Order_Details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private  double quantity;
    private double lineDiscountAmount;
    private double lineDiscountPer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId",updatable = false,nullable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId",updatable = false,nullable = true)
    @JsonIgnore
    private Product product;

    @JsonIgnore
    public OrderDetailsDTO getDto(){
        OrderDetailsDTO dto = new OrderDetailsDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }

}
