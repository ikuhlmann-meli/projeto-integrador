package com.w4.projetoIntegrador.service;

import com.w4.projetoIntegrador.entities.ItemCart;
import com.w4.projetoIntegrador.exceptions.NotFoundException;
import com.w4.projetoIntegrador.repository.ItemCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCartService {

    @Autowired
    ItemCartRepository itemCartRepository;

    public ItemCart getPurchaseProduct(Long id) {
        try {
            return itemCartRepository.findById(id).orElse(null);
        } catch (RuntimeException e) {
            throw new NotFoundException("Product " + id + " não encontrada na base de dados.");
        }
    }

    public ItemCart create(ItemCart itemCart) {
        return itemCartRepository.save(itemCart);
    }
}

