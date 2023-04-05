package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepoImpl implements ProductRepo{

    @Override
    public Product findById() {
        return new Product(111, "Dell", 900);
    }
}
