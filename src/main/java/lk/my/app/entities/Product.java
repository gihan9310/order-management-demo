package lk.my.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.my.app.models.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,nullable = false,unique = true,updatable = false)
    private String productCode;
    @Column(length = 100,nullable = false)
    private String productDescription;
    private Long aviableQty=0l;

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
    public ProductDTO getDto(){
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }

}
