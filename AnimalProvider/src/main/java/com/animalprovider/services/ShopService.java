package com.animalprovider.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animalprovider.dao.ShopRepository;
import com.animalprovider.entities.Shop;

@Service
public class ShopService {
    
    @Autowired
    private ShopRepository shopRepository;
    
    public List<Shop> getAllShops() {
        return (List<Shop>) shopRepository.findAll();
    }
    
    public Shop getShopById(Integer id) {
        return shopRepository.findById(id).orElse(null);
    }
    
    public boolean saveShop(Shop shop) {
        Shop x = shopRepository.save(shop);
        if(Objects.isNull(x))
        	return false;
        return true;
    }
    
    public void deleteShop(Integer id) {
        shopRepository.deleteById(id);
    }
}