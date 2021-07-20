package lk.my.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.my.app.models.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
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
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    @Column(length = 40,nullable = false)
    private String customerName;
    @Column(length = 10,nullable = false)
    private String mobile;
    @Column(nullable =true )
    private Double totalDiscountPer=0d;
    @Column(nullable =true )
    private double totalDiscountValue;
    private double finalPaymentValue;
    private double balance;
    private double invoiceValue;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "order",cascade = CascadeType.REFRESH,orphanRemoval = true)
//    List<OrderDetails>orderDetails;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    @PrePersist
    @JsonIgnore
    public void  createdDate(){
       this.createdDate =LocalDateTime.now();
    }

    @PreUpdate
    @JsonIgnore
    public void  updateDate(){
        this.updateDate =LocalDateTime.now();
    }

    @JsonIgnore
    public OrderDTO getDto(){
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }

}
