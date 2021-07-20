package lk.my.app.repoitories;

import lk.my.app.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails ,Long> {
}
