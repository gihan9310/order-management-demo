package lk.my.app.repoitories;

import lk.my.app.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface OrderRepository extends JpaRepository<Order ,Long> {
}
