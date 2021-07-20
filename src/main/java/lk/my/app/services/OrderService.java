package lk.my.app.services;

import lk.my.app.entities.Order;
import lk.my.app.entities.OrderDetails;
import lk.my.app.entities.Product;
import lk.my.app.models.OrderDTO;
import lk.my.app.repoitories.OrderDetailsRepository;
import lk.my.app.repoitories.OrderRepository;
import lk.my.app.repoitories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderDTO save(OrderDTO dto) {

        try{

            Order entity = dto.getEntity();
            orderRepository.save(entity);
            List<OrderDetails> list = new ArrayList<>();
            dto.getOrderDetails().forEach(i->{
                OrderDetails details = i.getEntity();
                details.setOrder(entity);
                Optional<Product> product = productRepository.findById(i.getProductId());
                details.setProduct(product.isPresent()?product.get():null);
                list.add(details);
            });
            orderDetailsRepository.saveAll(list);

            return entity.getDto();

        }catch (Exception e){

            e.printStackTrace();
            return  null ;
        }
    }
}
