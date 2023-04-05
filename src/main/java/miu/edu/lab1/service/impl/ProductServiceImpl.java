package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.Product;
import miu.edu.lab1.repo.ProductRepo;
import miu.edu.lab1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public Product findById() {
        return productRepo.findById();
    }

}
