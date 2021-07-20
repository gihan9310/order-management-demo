package lk.my.app.services;

import lk.my.app.entities.Product;
import lk.my.app.exceptions.ProductException;
import lk.my.app.models.ProductDTO;
import lk.my.app.repoitories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductDTO save(ProductDTO product) {

        try {
            log.debug("product saving");
            Product result = productRepository.save(product.getEntity());
            return result.getDto();
        }catch (Exception e){
//            e.printStackTrace();
            log.error(e.getMessage());
            throw new ProductException("Project code already used.");
        }
    }

    public ProductDTO update(ProductDTO product) {

        try {
            log.debug("product update");
            Product result = productRepository.save(product.getEntity());
            return result.getDto();
        }catch (Exception e){
//            e.printStackTrace();
            log.error(e.getMessage());
            throw new ProductException("Project code already used.");
        }

    }

    public List<ProductDTO> findAll() {

        try {
            List<Product> all = productRepository.findAll();
            List<ProductDTO> list = new ArrayList<>();
            all.forEach(i->list.add(i.getDto()));
            return  list;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ProductException("Can not find All");
        }
    }

    public ProductDTO findById(Long id) {

        try {
            Optional<Product> product = productRepository.findById(id);
           return product.isPresent() ? product.get().getDto() : null;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ProductException("Not Found.");
        }
    }

    public Long delete(Long id) {
        try {
             productRepository.deleteById(id);
            return id;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ProductException("Can not Delete.");
        }
    }
}
