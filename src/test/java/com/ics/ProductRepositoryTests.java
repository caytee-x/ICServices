package com.ics;

import com.ics.models.Product;
import com.ics.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ProductRepository repo;

    //C3
    //REQ B-F03
    ///CHANGES PRODUCT ID // HAVE TO UPDATE IN DB
    @Test
    public void changeProductUnitPrice(){
       Long id = Long.valueOf(1);
       BigDecimal unit_price = BigDecimal.valueOf(1.15);
       Product p = repo.findByProductId(id);
       Product pc = new Product(p.getId(), p.getImg_path(),p.getName(),p.getDescription(),unit_price);
       repo.deleteById(id);
       repo.save(pc);



    }


}
