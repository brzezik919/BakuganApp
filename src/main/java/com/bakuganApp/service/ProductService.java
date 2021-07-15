package com.bakuganApp.service;

import com.bakuganApp.model.Product;
import com.bakuganApp.model.ProductRepository;
import com.bakuganApp.model.User;
import com.bakuganApp.model.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public boolean changeCurrencyUserProduct(int idProduct, int idNewUser){
        try{

            User newUser = userRepository.findById(idNewUser);
            Product productToSave = productRepository.findById(idProduct);
            productToSave.setOwner(newUser);
            productRepository.save(productToSave);
            return true;
        }
        catch(NullPointerException e){
            return false;
        }

    }

    public List<Product> getListProduct(int id){
        return productRepository.findByOwner_Id(id);
    }
}
