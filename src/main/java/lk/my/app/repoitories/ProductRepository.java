package lk.my.app.repoitories;

import lk.my.app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    boolean existsByProductCode(String code);

    Product findByIdAndProductCode(Long id ,String productCode);

//    @Query(value ="SELECT new lk.my.app.models.ProductDTO(o.id,a.productCode,a.productDescription,a.aviableQty,a.createdDate,a.updateDate) FROM Product a LEFT join Order o on o.id =a.id WHERE a.productCode=?1")
//    Product findProductByProductCode(String code);

}
